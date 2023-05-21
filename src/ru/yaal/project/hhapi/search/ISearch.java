package ru.yaal.project.hhapi.search;

/**
 * Поиск.
 */
public interface ISearch<T> {
    T search() throws SearchException;

    /**
     * Можно строить цепочку параметров.
     * @param parameter параметр
     * @throws SearchException исключение если поиск не работает
     * @return поиск
     */
    ISearch<T> addParameter(ISearchParameter parameter) throws SearchException;

    ISearch<T> addParameter(SearchParameterBox parameterBox) throws SearchException;
}
