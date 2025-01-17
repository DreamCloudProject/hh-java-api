package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaDictionaryTest {
    public static final String LEN_OBLAST_ID = "145";
    public static final String LEN_OBLAST_NAME = "ЛеНиНгРаДсКаЯ оБлАсТь";
    public static final String SPB_ID = "2";
    public static final String SPB_NAME = "СаНкТ-ПеТеРбУрГ";
    private static final String RUSSIA_ID = "113";
    private static final String RUSSIA_NAME = "РоСсИя";
    private AreaDictionary areas;

    @Before
    public void before() {
        areas = Area.AREAS;
    }

    @Test
    public void hasById() {
        assertTrue(areas.hasId(RUSSIA_ID));
        assertTrue(areas.hasId(LEN_OBLAST_ID));
        assertTrue(areas.hasId(SPB_ID));
        assertFalse(areas.hasId("1000"));
    }

    @Test
    public void hasByName() {
        assertTrue(areas.hasName(RUSSIA_NAME));
        assertTrue(areas.hasName(LEN_OBLAST_NAME));
        assertTrue(areas.hasName(SPB_NAME));
        assertFalse(areas.hasName("Море дождей"));
    }

    @Test
    public void getById() {
        assertTrue(RUSSIA_NAME.equalsIgnoreCase(areas.getById(RUSSIA_ID).getName()));
        assertTrue(LEN_OBLAST_NAME.equalsIgnoreCase(areas.getById(LEN_OBLAST_ID).getName()));
        assertTrue(SPB_NAME.equalsIgnoreCase(areas.getById(SPB_ID).getName()));
    }

    @Test
    public void getByName() {
        assertEquals(RUSSIA_ID, areas.getByName(RUSSIA_NAME).getId());
        assertEquals(LEN_OBLAST_ID, areas.getByName(LEN_OBLAST_NAME).getId());
        assertEquals(SPB_ID, areas.getByName(SPB_NAME).getId());
    }

}
