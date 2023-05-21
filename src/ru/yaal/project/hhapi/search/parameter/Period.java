package ru.yaal.project.hhapi.search.parameter;

import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

import static java.lang.String.format;

/**
 * Период поиска вакансий: за сколько дней искать вакансии.
 * Максимум 30 дней (ограничение HeadHunter).
 */
public final class Period implements ISearchParameter {
    public static final int MIN_PERIOD = 1;
    public static final int MAX_PERIOD = 30;
    private Integer period;

    /**
     * Период поиска вакансий: за сколько дней искать вакансии.
     *
     * @param period Период поиска вакансий. Максимум 30 дней (ограничение HeadHunter).
     */
    public Period(Integer period) throws SearchException {
        setPeriod(period);
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.PERIOD, String.valueOf(getPeriod()));
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) throws SearchException {
        if (period < MIN_PERIOD || period > MAX_PERIOD) {
            throw new SearchException(
                    format("Некорректный период. Ожидается %d-%d. Получено %d.", MIN_PERIOD, MAX_PERIOD, period));
        }
        this.period = period;
    }

    @Override
    public String getSearchParameterName() {
        return "Период";
    }
}
