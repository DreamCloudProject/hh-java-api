package ru.yaal.project.hhapi.dictionary.entry.entries.area;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.IDictionary;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;
import ru.yaal.project.hhapi.parser.IParser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AreasParserTest {

    public void test() throws Exception {
        String content = ContentLoaderFactory.newInstanceLongTermCache().loadContent(UrlConstants.AREAS_URL);
        IParser<AreaDictionary> parser = new AreasParser();
        IDictionary<Area> areas = parser.parse(content);
        assertNotNull(areas);
        assertEquals(6, areas.size());
    }

}
