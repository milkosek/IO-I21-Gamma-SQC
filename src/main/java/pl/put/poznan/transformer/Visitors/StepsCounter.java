package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

public class StepsCounter implements ScenarioPartVisitor {
    int count;

    @Override
    public void visit(Scenario scenario) {
        this. count = scenario.getSteps().size();
    }

    public int returnCount() {
        return this.count;
    }

    @Override
    public void visit(Title title) {

    }

    @Override
    public void visit(Actor actor) {

    }

    @Override
    public void visit(SystemActor systemActor) {

    }

    @Override
    public void visit(Step step) {

    }
}
