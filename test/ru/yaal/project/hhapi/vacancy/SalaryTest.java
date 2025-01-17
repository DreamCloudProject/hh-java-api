package ru.yaal.project.hhapi.vacancy;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yaal.project.hhapi.HhApi;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.dictionary.entry.entries.small.Currency;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;

import static org.junit.Assert.*;
import static ru.yaal.project.hhapi.vacancy.SalaryTest.SalaryEquals.salaryEquals;

public class SalaryTest {
    private static final Logger LOG = LoggerFactory.getLogger(SalaryTest.class);
    /**
     * Предельный курс доллара для тестов.
     * Надеюсь, увеличивать не придется %)
     */
    private static final int MAX_USD_RATE = 100;

    @Test
    public void testOnlyWithSalary() throws SearchException {
        for (Vacancy vacancy : HhApi.search(50, Constants.OnlyWithSalary.ON)) {
            Salary actSalary = vacancy.getSalary();
            assertNotNull(actSalary);
            assertTrue(actSalary.getFrom() != null || actSalary.getTo() != null);
        }
    }

    public void testSalary() throws SearchException {
        final Salary expSalary = new Salary(100000);
        for (Vacancy vacancy : HhApi.search(50, expSalary)) {
            Salary actSalary = vacancy.getSalary();
            if (actSalary.getFrom() != null || actSalary.getTo() != null) {
                assertThat(actSalary, salaryEquals(expSalary));
            }
        }
    }

    @Test
    public void testSalaryAndOnlyWithSalary() throws SearchException {
        final Salary expSalary = new Salary(50000);
        for (Vacancy vacancy : HhApi.search(50, expSalary, Constants.OnlyWithSalary.ON)) {
            Salary actSalary = vacancy.getSalary();
            //assertThat(actSalary, salaryEquals(expSalary));
        }
    }

    @Test(expected = SearchException.class)
    public void testSalaryNotSpecified() throws SearchException {
        ISearchParameter parameter = new Salary(null);
        parameter.getSearchParameters();
    }

    @Test
    public void putCurrencyToSearchParams() throws SearchException {
        final Currency expCurrency = Constants.Currency.USD;
        final int salaryUsd = 1000;
        final Salary expSalary = new Salary(salaryUsd, salaryUsd, expCurrency);
        for (Vacancy vacancy : HhApi.search(expSalary, Constants.OnlyWithSalary.ON)) {
            //todo переписать проверку с испльзованием матчера SalaryEquals
            Salary actSalary = vacancy.getSalary();
            System.out.println(actSalary.getFrom());
            System.out.println(actSalary.getTo());
            System.out.println(actSalary.getCurrency());
            //assertThat(actSalary, SalaryEquals.salaryEquals(actSalary));
        }
    }

    @Test
    public void toRur() {
        int fromUsd = 1000;
        int toUsd = 3000;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Constants.Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertTrue(salaryRur.getFrom() > fromUsd * 29);
        assertTrue(salaryRur.getTo() < toUsd * MAX_USD_RATE);
        assertEquals(Constants.Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurNullFrom() {
        Integer fromUsd = null;
        int toUsd = 3000;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Constants.Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertNull(salaryRur.getFrom());
        assertTrue(salaryRur.getTo() < toUsd * MAX_USD_RATE);
        assertEquals(Constants.Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurNullTo() {
        int fromUsd = 1000;
        Integer toUsd = null;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Constants.Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertTrue(salaryRur.getFrom() > fromUsd * 29);
        assertNull(salaryRur.getTo());
        assertEquals(Constants.Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurNulls() {
        Integer fromUsd = null;
        Integer toUsd = null;
        Salary salaryUsd = new Salary(fromUsd, toUsd, Constants.Currency.USD);
        Salary salaryRur = Salary.toRur(salaryUsd);
        assertNull(salaryRur.getFrom());
        assertNull(salaryRur.getTo());
        assertEquals(Constants.Currency.RUR, salaryRur.getCurrency());
    }

    @Test
    public void toRurFromRur() {
        Integer from = 1000;
        Integer to = 3000;
        Salary salary = new Salary(from, to, Constants.Currency.RUR);
        Salary salaryRur = Salary.toRur(salary);
        assertEquals(from, salaryRur.getFrom());
        assertEquals(to, salaryRur.getTo());
        assertEquals(Constants.Currency.RUR, salaryRur.getCurrency());
    }

    public static class SalaryEquals extends TypeSafeMatcher<Salary> {
        private Salary actSalary;

        public SalaryEquals(Salary actSalary) {
            this.actSalary = actSalary;
        }

        @Factory
        public static org.hamcrest.Matcher<Salary> salaryEquals(Salary actSalary) {
            return new SalaryEquals(actSalary);
        }

        @Override
        public boolean matchesSafely(Salary expSalary) {
            try {
                Salary expSalaryRur = Salary.toRur(expSalary);
                Salary actSalaryRur = Salary.toRur(actSalary);
                Integer expValue = Integer.valueOf(expSalaryRur.getSearchParameters()
                        .getParameterMap().get(SearchParamNames.SALARY).get(0));
                assertNotNull(expValue);
                Integer actTo = actSalaryRur.getTo();
                Integer actFrom = actSalaryRur.getFrom();
                assertTrue(actTo != null || actFrom != null);
                actTo = (actTo != null) ? actTo : actFrom;
                actFrom = (actFrom != null) ? actFrom : actTo;
                return (expValue >= actFrom || expValue <= actTo);
            } catch (SearchException e) {
                LOG.error(e.getMessage(), e);
                return false;
            }
        }

        public void describeTo(Description description) {
            description.appendText("salary not equals:");
            description.appendValue(actSalary);
        }

    }

}
