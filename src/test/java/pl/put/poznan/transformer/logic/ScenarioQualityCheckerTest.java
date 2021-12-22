package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Visitors.KeywordCounter;
import pl.put.poznan.transformer.Visitors.MistakeChecker;
import pl.put.poznan.transformer.Visitors.StepsCounter;

import static org.junit.jupiter.api.Assertions.*;

class ScenarioQualityCheckerTest {

    private Scenario scenario;

    @BeforeEach
    void setUp(){
        scenario = new Scenario("Ex", new String[]{"Bibliotekarz"}, new String[]{"System"}, new String[]{"Bibliotekarz wybiera opcję dodania nowej pozycji książkowej",
                "Wyświetla się formularz.", "IF: Bibliotekarz pragnie dodać egzemplarze książki", " System prezentuje zdefiniowane egzemplarze",
                " FOR EACH egzemplarz:", "  Bibliotekarz podaje dane egzemplarza i zatwierdza."});
    }

    @Test
    void stepsCounterTest(){
        StepsCounter stepsCounter = new StepsCounter();
        scenario.accept(stepsCounter);
        assertEquals(6, stepsCounter.getCount());
    }

    @Test
    void KeywordCounterTest(){
        KeywordCounter keywordCounter = new KeywordCounter();
        scenario.accept(keywordCounter);
        assertEquals(2, keywordCounter.getKeywordCount());
    }

    @Test
    void MistakeCheckerTest(){
        MistakeChecker mistakeChecker = new MistakeChecker();
        scenario.accept(mistakeChecker);
        assertEquals("Wyświetla się formularz.\n", mistakeChecker.getMistakes());
    }
}