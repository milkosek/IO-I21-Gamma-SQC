package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Visitors.KeywordCounter;
import pl.put.poznan.transformer.Visitors.MistakeChecker;
import pl.put.poznan.transformer.Visitors.StepEnumerator;
import pl.put.poznan.transformer.Visitors.StepsCounter;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class ScenarioQualityChecker {

    private final Scenario scenario;

    public ScenarioQualityChecker(Scenario trans){
        this.scenario = trans;
    }

    public String transform(String option){
        String answer = "";

        switch(option) {
            case "count":
                StepsCounter stepsCounter = new StepsCounter();
                scenario.accept(stepsCounter);
                answer = "" + stepsCounter.getCount();
                break;

            case "countKeywords":
                KeywordCounter keywordCounter = new KeywordCounter();
                scenario.accept(keywordCounter);
                answer = "" + keywordCounter.getKeywordCount();
                break;

            case "enumerate":
                StepEnumerator stepEnumerator = new StepEnumerator();
                stepEnumerator.visit(scenario);
                answer = this.scenario.getAllSteps();
                break;

            case "mistakes":
                MistakeChecker mistakeCounter = new MistakeChecker();
                scenario.accept(mistakeCounter);
                answer = mistakeCounter.getMistakes();
                break;

            default:
                answer = "Unknown option";
                break;
        }
        return answer;
    }
}
