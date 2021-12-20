package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.Scenario.Scenario;

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
        // of course, normally it would do something based on the transforms
        //return text.toUpperCase();
        /*if (option == "all") {
            return
        }*/
        return this.trans.getAll();
    }
}
