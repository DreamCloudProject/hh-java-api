package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.dictionary.entry.AbstractDictionaryEntry;
import ru.yaal.project.hhapi.search.SearchException;
import ru.yaal.project.hhapi.search.ISearchParameter;
import ru.yaal.project.hhapi.search.SearchParamNames;
import ru.yaal.project.hhapi.search.SearchParameterBox;

/**
 * ���������� ������ ��������.
 */
public final class Order extends AbstractDictionaryEntry implements ISearchParameter {
    public static final Order NULL_ORDER = new Order();
    public static final IDictionary<Order> ORDERS = SmallDictionariesInitializer.getInstance().getOrder();
    /**
     * �� ����.
     */
    public static final Order PUBLICATION_TIME = ORDERS.getById("publication_time");
    /**
     * �� �������� ��������.
     */
    public static final Order SALARY_DESC = ORDERS.getById("salary_desc");
    /**
     * �� ����������� ��������.
     */
    public static final Order SALARY_ASC = ORDERS.getById("salary_asc");
    /**
     * �� ������������.
     */
    public static final Order RELEVANCE = ORDERS.getById("relevance");

    private Order() {
    }

    @Override
    public SearchParameterBox getSearchParameters() throws SearchException {
        return new SearchParameterBox(SearchParamNames.ORDER_BY, getId());
    }

    @Override
    public String getSearchParameterName() {
        return "���������� ��������";
    }
}