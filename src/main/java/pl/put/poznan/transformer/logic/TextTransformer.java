package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Visitors.KeywordCounter;
import pl.put.poznan.transformer.Visitors.MistakeCounter;
import pl.put.poznan.transformer.Visitors.StepEnumerator;
import pl.put.poznan.transformer.Visitors.StepsCounter;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final Scenario trans;

    public TextTransformer(Scenario trans){
        this.trans = trans;
    }

    public String transform(String option){
        String answer = "";

        switch(option) {
            case "count":
                StepsCounter stepsCounter = new StepsCounter();
                trans.accept(stepsCounter);
                //stepsCounter.visit(trans);
                answer = "" + stepsCounter.getCount();
                break;

            case "countKeywords":
                KeywordCounter keywordCounter = new KeywordCounter();
                trans.accept(keywordCounter);
                //keywordCounter.visit(trans);
                answer = "" + keywordCounter.getKeywordCount();
                break;

            case "enumerate":
                StepEnumerator stepEnumerator = new StepEnumerator();
                stepEnumerator.visit(trans);
                answer = this.trans.getAllSteps();
                break;

            case "mistakes":
                MistakeCounter mistakeCounter = new MistakeCounter();
                trans.accept(mistakeCounter);
                answer = mistakeCounter.getMistakes();
                break;

            default:
                answer = "Unknown option";
                break;
        }
        return answer;
    }
}
