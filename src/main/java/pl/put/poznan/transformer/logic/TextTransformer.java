package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.Visitors.StepsCounter;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;
    private final Scenario trans;
    private final StepsCounter SC;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
        this.trans = null;
        this.SC = new StepsCounter();
    }

    public TextTransformer(Scenario trans){
        this.trans = trans;
        this.transforms = null;
        this.SC = new StepsCounter();
    }

    public String transform(String option){
        String answer = new String();

        switch(option) {
            case "count":
                SC.visit(trans);
                answer = "" + SC.returnCount();
                break;
            case "r":
                answer = this.trans.getAll();
                break;
        }
        return answer;
    }
}
