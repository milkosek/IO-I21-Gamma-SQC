package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Visitors.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class ScenarioQualityChecker {

    private final Scenario scenario;
    private Integer depth;
    private String arg1;

    public ScenarioQualityChecker(Scenario scen){
        this.scenario = scen;
    }

    public ScenarioQualityChecker(Scenario scen, Integer depth){
        this.scenario = scen;
        this.depth = depth;
    }

    public ScenarioQualityChecker(Scenario scen, String arg1){
        this.scenario = scen;
        this.arg1 = arg1;
    }

    public String transform(String option, HttpServletResponse response) throws IOException {
        String answer;

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
                scenario.accept(stepEnumerator);
                answer = stepEnumerator.getEnumerated();
                break;

            case "mistakes":
                MistakeChecker mistakeCounter = new MistakeChecker();
                scenario.accept(mistakeCounter);
                answer = mistakeCounter.getMistakes();
                break;

            case "simplify":
                Simplifier simp = new Simplifier();
                simp.setDepth(this.depth);
                scenario.accept(simp);
                answer = simp.getSimplified();
                break;

            case "search":
                Grep grep = new Grep();
                grep.setWord(this.arg1);
                scenario.accept(grep);
                answer = grep.getFound();
                break;

            case "unused":
                ActorChecker actorChecker = new ActorChecker();
                scenario.accept(actorChecker);
                answer = actorChecker.getUnused();
                break;

            default:
                answer = "Unknown option";
                break;
        }
        return answer;
    }
}
