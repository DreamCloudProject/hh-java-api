package ru.yaal.project.hhapi.dictionary.entry.entries.small;

import org.junit.Test;
import ru.yaal.project.hhapi.parser.IParser;

import static org.junit.Assert.assertNotNull;

public class SmallDictionariesParserTest {

    @Test
    public void test() throws Exception {
        final String requestContent = ""
                + "{\"resume_contacts_site_type\": ["
                + "{\"id\": \"personal\", \"name\": \"Другой сайт\"}, "
                + "{\"id\": \"moi_krug\", \"name\": \"Мой круг\"}, "
                + "{\"id\": \"livejournal\", \"name\": \"LiveJournal\"}, "
                + "{\"id\": \"linkedin\", \"name\": \"LinkedIn\"}, "
                + "{\"id\": \"freelance\", \"name\": \"Free-lance\"}, "
                + "{\"id\": \"facebook\", \"name\": \"Facebook\"}, "
                + "{\"id\": \"skype\", \"name\": \"Skype\"}, "
                + "{\"id\": \"icq\", \"name\": \"ICQ\"}, "
                + "{\"id\": \"jabber\", \"name\": \"Jabber\"}], "
                + ""
                + "\"schedule\": ["
                + "{\"id\": \"fullDay\", \"name\": \"Полный день\"}, "
                + "{\"id\": \"shift\", \"name\": \"Сменный график\"}, "
                + "{\"id\": \"flexible\", \"name\": \"Гибкий график\"}, "
                + "{\"id\": \"remote\", \"name\": \"Удаленная работа\"}], "
                + ""
                + "\"business_trip_readiness\": ["
                + "{\"id\": \"ready\", \"name\": \"Готов к командировкам\"}, "
                + "{\"id\": \"sometimes\", \"name\": \"Готов к редким командировкам\"}, "
                + "{\"id\": \"never\", \"name\": \"Не готов к командировкам\"}], "
                + ""
                + "\"vacancy_search_fields\": ["
                + "{\"id\": \"name\", \"name\": \"в названии вакансии\"}, "
                + "{\"id\": \"company_name\", \"name\": \"в названии компании\"}, "
                + "{\"id\": \"description\", \"name\": \"в описании вакансии\"}], "
                + ""
                + "\"currency\": ["
                + "{\"default\": true, \"rate\": 1.0, \"code\": \"RUR\", \"abbr\": \"руб.\", \"name\": \"Рубли\"}, "
                + "{\"default\": false, \"rate\": 0.024628000000000001, \"code\": \"AZN\", \"abbr\": \"AZN\", \"name\": \"Манаты\"}, "
                + "{\"default\": false, \"rate\": 286.13367599999998, \"code\": \"BYR\", \"abbr\": \"бел.руб.\", \"name\": \"Белорусские рубли\"}, "
                + "{\"default\": false, \"rate\": 0.024961000000000001, \"code\": \"EUR\", \"abbr\": \"EUR\", \"name\": \"Евро\"}, "
                + "{\"default\": false, \"rate\": 4.6843009999999996, \"code\": \"KZT\", \"abbr\": \"KZT\", \"name\": \"Тенге\"}, "
                + "{\"default\": false, \"rate\": 0.25418099999999999, \"code\": \"UAH\", \"abbr\": \"грн\", \"name\": \"Гривны\"}, "
                + "{\"default\": false, \"rate\": 0.03338, \"code\": \"USD\", \"abbr\": \"USD\", \"name\": \"Доллары\"}], "
                + ""
                + "\"travel_time\": ["
                + "{\"id\": \"any\", \"name\": \"Не имеет значения\"}, "
                + "{\"id\": \"less_than_hour\", \"name\": \"Не более часа\"}, "
                + "{\"id\": \"from_hour_to_one_and_half\", \"name\": \"Не более полутора часов\"}], "
                + ""
                + "\"education_level\": ["
                + "{\"id\": \"higher\", \"name\": \"Высшее\"}, "
                + "{\"id\": \"BACHELOR\", \"name\": \"Бакалавр\"}, "
                + "{\"id\": \"master\", \"name\": \"Магистр\"}, "
                + "{\"id\": \"candidate\", \"name\": \"Кандидат наук\"}, "
                + "{\"id\": \"doctor\", \"name\": \"Доктор наук\"}, "
                + "{\"id\": \"unfinished_higher\", \"name\": \"Неоконченное высшее\"}, "
                + "{\"id\": \"secondary\", \"name\": \"Среднее\"}, "
                + "{\"id\": \"special_secondary\", \"name\": \"Среднее специальное\"}], "
                + ""
                + "\"relocation_type\": ["
                + "{\"id\": \"no_relocation\", \"name\": \"не готов к переезду\"}, "
                + "{\"id\": \"relocation_possible\", \"name\": \"готов к переезду\"}, "
                + "{\"id\": \"relocation_desirable\", \"name\": \"хочу переехать\"}], "
                + ""
                + "\"resume_access_type\": ["
                + "{\"id\": \"no_one\", \"name\": \"закрытое (резюме не видно никому)\"}, "
                + "{\"id\": \"whitelist\", \"name\": \"резюме видно только выбранным компаниям\"}, "
                + "{\"id\": \"blacklist\", \"name\": \"все компании, кроме выбранных (список в настройках видимости)\"}, "
                + "{\"id\": \"clients\", \"name\": \"видят только клиенты hh.ru\"}, "
                + "{\"id\": \"everyone\", \"name\": \"видно всему интернету\"}, "
                + "{\"id\": \"direct\", \"name\": \"Резюме видно только по прямой ссылке\"}], "
                + ""
                + "\"employment\": ["
                + "{\"id\": \"full\", \"name\": \"Полная занятость\"}, "
                + "{\"id\": \"part\", \"name\": \"Частичная занятость\"}, "
                + "{\"id\": \"project\", \"name\": \"Проектная работа\"}, "
                + "{\"id\": \"volunteer\", \"name\": \"Волонтерство\"}, "
                + "{\"id\": \"probation\", \"name\": \"Стажировка\"}], "
                + ""
                + "\"vacancy_label\": ["
                + "{\"id\": \"with_address\", \"name\": \"Только с адресом\"}, "
                + "{\"id\": \"accept_handicapped\", \"name\": \"Только доступные для людей с инвалидностью\"}, "
                + "{\"id\": \"not_from_agency\", \"name\": \"Без вакансий агентств\"}], "
                + ""
                + "\"gender\": ["
                + "{\"id\": \"unknown\", \"name\": \"Не скажу\"}, "
                + "{\"id\": \"male\", \"name\": \"Мужской\"}, "
                + "{\"id\": \"female\", \"name\": \"Женский\"}], "
                + ""
                + "\"language_level\": ["
                + "{\"id\": \"basic\", \"name\": \"базовые знания\"}, "
                + "{\"id\": \"can_read\", \"name\": \"читаю профессиональную литературу\"}, "
                + "{\"id\": \"can_pass_interview\", \"name\": \"могу проходить интервью\"}, "
                + "{\"id\": \"fluent\", \"name\": \"свободно владею\"}, "
                + "{\"id\": \"native\", \"name\": \"родной\"}], "
                + ""
                + "\"experience\": ["
                + "{\"id\": \"noExperience\", \"name\": \"Нет опыта\"}, "
                + "{\"id\": \"between1And3\", \"name\": \"От 1 года до 3 лет\"}, "
                + "{\"id\": \"between3And6\", \"name\": \"От 3 до 6 лет\"}, "
                + "{\"id\": \"moreThan6\", \"name\": \"Более 6 лет\"}], "
                + ""
                + "\"preferred_contact_type\": ["
                + "{\"id\": \"home\", \"name\": \"Домашний телефон\"}, "
                + "{\"id\": \"work\", \"name\": \"Рабочий телефон\"}, "
                + "{\"id\": \"cell\", \"name\": \"Мобильный телефон\"}, "
                + "{\"id\": \"email\", \"name\": \"Эл. почта\"}], "
                + ""
                + "\"vacancy_search_order\": ["
                + "{\"id\": \"publication_time\", \"name\": \"по дате\"}, "
                + "{\"id\": \"salary_desc\", \"name\": \"по убыванию зарплаты\"}, "
                + "{\"id\": \"salary_asc\", \"name\": \"по возрастанию зарплаты\"}, "
                + "{\"id\": \"relevance\", \"name\": \"по соответствию\"}], "
                + ""
                + "\"vacancy_type\": ["
                + "{\"id\": \"open\", \"name\": \"Открытая\"}, "
                + "{\"id\": \"closed\", \"name\": \"Закрытая\"}, "
                + "{\"id\": \"anonymous\", \"name\": \"Анонимная\"}, "
                + "{\"id\": \"direct\", \"name\": \"С прямым откликом\"}], "
                + ""
                + "\"site_lang\": ["
                + "{\"id\": \"ru\", \"name\": \"По-русски\"}, "
                + "{\"id\": \"en\", \"name\": \"In English\"}]}";
        IParser<SmallDictionariesContainer> parser = new SmallDictionariesParser();
        SmallDictionariesContainer dictionaries = parser.parse(requestContent);
        assertNotNull(dictionaries);
    }

}
