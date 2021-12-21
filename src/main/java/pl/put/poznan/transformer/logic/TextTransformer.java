package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Visitors.KeywordCounter;
import pl.put.poznan.transformer.Visitors.StepsCounter;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;
    private final Scenario trans;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
        this.trans = null;
    }

    public TextTransformer(Scenario trans){
        this.trans = trans;
        this.transforms = null;
    }

    public String transform(String option){
        String answer = new String();

        switch(option) {
            case "count":
                StepsCounter stepsCounter = new StepsCounter();
                stepsCounter.visit(trans);
                answer = "" + stepsCounter.returnCount();
                break;
            case "countKeywords":
                KeywordCounter keywordCounter = new KeywordCounter();
                keywordCounter.visit(trans);
                answer = "" + keywordCounter.returnKeywordCount();
                break;
            case "r":
                answer = this.trans.getAll();
                break;
        }
        return answer;
    }
}
