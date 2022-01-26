package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Scenario.Step;
import pl.put.poznan.transformer.Visitors.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScenarioQualityCheckerTest {

    private Scenario scenario;

    @BeforeEach
    void setUp(){
        scenario = new Scenario("Ex", new String[]{"Bibliotekarz", "Zły"}, new String[]{"System"}, new String[]{"Bibliotekarz wybiera opcję dodania nowej pozycji książkowej",
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
    void StepEnumeratorTest(){
        StepEnumerator stepEnumerator = new StepEnumerator();
        scenario.accept(stepEnumerator);
        assertEquals("1. Bibliotekarz wybiera opcję dodania nowej pozycji książkowejㅤ\n2. Wyświetla się formularz.ㅤ\n3. IF: Bibliotekarz pragnie dodać egzemplarze książkiㅤ\n3.1. System prezentuje zdefiniowane egzemplarzeㅤ\n3.2. FOR EACH egzemplarz:ㅤ\n3.2.1. Bibliotekarz podaje dane egzemplarza i zatwierdza.ㅤ\n", stepEnumerator.getEnumerated());
    }

    @Test
    void MistakeCheckerTest(){
        MistakeChecker mistakeChecker = new MistakeChecker();
        scenario.accept(mistakeChecker);
        assertEquals("Wyświetla się formularz.\n", mistakeChecker.getMistakes());
    }

    @Test
    void ActorCheckerTest(){
        ActorChecker actorChecker = new ActorChecker();
        scenario.accept(actorChecker);
        assertEquals("Zły\n", actorChecker.getUnused());
    }

    @Test
    void StepFinderTest(){
        StepFinder stepFinder = new StepFinder(3);
        scenario.accept(stepFinder);
        assertEquals("IF: Bibliotekarz pragnie dodać egzemplarze książkiㅤ\n System prezentuje zdefiniowane egzemplarzeㅤ\n FOR EACH egzemplarz:ㅤ\n  Bibliotekarz podaje dane egzemplarza i zatwierdza.ㅤ\n", stepFinder.getAns());
    }

    @Test
    void KeywordCounterMockTest(){
        KeywordCounter keywordCounter = new KeywordCounter();
        Step step = mock(Step.class);
        when(step.getStep()).thenReturn("IF: Bibliotekarz pragnie dodać egzemplarze książki");
        keywordCounter.visit(step);
        assertEquals(1, keywordCounter.getKeywordCount());
    }
}