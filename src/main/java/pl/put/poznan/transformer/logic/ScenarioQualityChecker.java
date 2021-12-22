package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Visitors.KeywordCounter;
import pl.put.poznan.transformer.Visitors.MistakeChecker;
import pl.put.poznan.transformer.Visitors.StepEnumerator;
import pl.put.poznan.transformer.Visitors.StepsCounter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class ScenarioQualityChecker {

    private final Scenario scenario;

    public ScenarioQualityChecker(Scenario scen){
        this.scenario = scen;
    }

    public String transform(String option, HttpServletResponse response) throws IOException {
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
                //stepEnumerator.visit(scenario);
                scenario.accept(stepEnumerator);
                answer = stepEnumerator.getEnumerated();
                //answer = this.scenario.getAllSteps();
                response.setContentType("text/plain;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-Disposition","attachment;filename=Scenario.txt");
                PrintWriter out = response.getWriter();
                out.println(answer);
                out.flush();
                out.close();
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
