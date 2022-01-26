package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

import java.util.ArrayList;
import java.util.List;

public class Simplifier implements ScenarioPartVisitor {

    private ArrayList<Step> simplified = new ArrayList<>();
    private int depth;

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public void visit(Scenario scenario) {
        for (Step step : scenario.getSteps() ) {
            if (step.getDepth() <= this.depth) {
                simplified.add(step);
            }
        }
    }

    @Override
    public void visit(Step step) {
        String stepText = step.getStep();
        step.setDepth(stepText.indexOf(stepText.trim()));
        step.setStep(stepText.trim());
    }

    @Override
    public void visit(Title title) {}

    @Override
    public void visit(Actor actor) {}

    @Override
    public void visit(SystemActor systemActor) {}

    public String getSimplified(){
        String answer = "";

        for (Step step : simplified) {
            //System.out.println(step.getStep());
            // "\n" doesn't work on strings ending with ":"?!
            // workaround using with "ㅤ" symbol (u+3164)
            answer += step.getStep() + "ㅤ\n";
        }
        return answer;
    }
}
