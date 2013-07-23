package ru.yaal.project.hhapi.parser;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.professionalfield.ProfessionalFieldDictionary;
import ru.yaal.project.hhapi.loader.ContentLoaderFactory;
import ru.yaal.project.hhapi.loader.UrlConstants;

import static org.junit.Assert.assertTrue;

public class ParserProfessionalFieldTest {

    @Test
    public void testParseSpecialization() throws Exception {
        String content = ContentLoaderFactory.newInstance().loadContent(UrlConstants.SPECIALIZATIONS_URL);
        IParser<ProfessionalFieldDictionary> parser = new ProfessionalFieldsParser();
        ProfessionalFieldDictionary dictionary = parser.parse(content);
        assertTrue(dictionary.hasEntryWithId("24.492"));
        assertTrue(dictionary.hasEntryWithName("Массажист"));
    }

}
