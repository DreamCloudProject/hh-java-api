package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

import static java.lang.String.format;

final class PerPage implements ISearchParameter {
    public static final int MIN_PER_PAGE = 1;
    public static final int MAX_PER_PAGE = 500;
    private Integer perPage;

    public PerPage(Integer perPage) throws SearchException {
        setPerPage(perPage);
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) throws SearchException {
        if (perPage < MIN_PER_PAGE || perPage > MAX_PER_PAGE) {
            throw new SearchException(
                    format("Некорректное количество найденных элементов на страницу. Ожидается %d-%d. Получено %d",
                            MIN_PER_PAGE, MAX_PER_PAGE, perPage));
        }
        this.perPage = perPage;
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.PER_PAGE, String.valueOf(getPerPage()));
    }

    @Override
    public String getSearchParameterName() {
        return "Количество вакансий на страницу";
    }
}
