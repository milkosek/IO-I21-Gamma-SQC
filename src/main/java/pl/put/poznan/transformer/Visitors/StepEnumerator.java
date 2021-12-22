package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

import java.util.List;

public class StepEnumerator implements ScenarioPartVisitor {

    private String enumerated;

    @Override
    public void visit(Scenario scenario) {
        /*for (Step step : scenario.getSteps()) {
            visit(step);
        }*/
        int depth = 0;
        while (iterateOverDepth(scenario.getSteps(), depth) > 1) {
            depth += 1;
        }
        setEnumerated(scenario.getAllSteps());
    }

    private int iterateOverDepth(List<Step> steps, int depth) {
        int iter = 0;
        int prevDepth = 0;
        int curDepth = 0;
        for (Step step : steps) {
            curDepth = step.getDepth();
            if (curDepth >= depth) {
                if (prevDepth < depth){
                    iter = 1;
                }
                else if (curDepth == depth) {
                    iter += 1;
                }
                step.setStep(addNum(step.getStep(), iter, depth));
            }
            prevDepth = curDepth;
        }
        return iter;
    }

    private String addNum(String text, int number, int depth) {
        if (depth == 0) {
            text = " " + text;
        }
        StringBuffer stringBuffer = new StringBuffer(text);
        stringBuffer.insert(depth * 2, number + ".");

        return stringBuffer.toString();
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

    public void setEnumerated(String steps){
        this.enumerated = steps;
    }

    public String getEnumerated(){
        return this.enumerated;
    }
}
