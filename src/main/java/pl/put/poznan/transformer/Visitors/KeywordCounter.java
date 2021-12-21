package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

public class KeywordCounter implements ScenarioPartVisitor {
    private int keywordCount;

    @Override
    public void visit(Scenario scenario) {
        this.keywordCount = 0;
        for (Step step : scenario.getSteps()) {
            visit(step);
        }
    }

    @Override
    public void visit(Step step) {
        String text = step.getStep().trim();
        if (text.matches("IF.*")) {
            this.keywordCount += 1;
        }
        else if (text.matches("ELSE.*")) {
            this.keywordCount += 1;
        }
        else if (text.matches("FOR EACH.*")) {
            this.keywordCount += 1;
        }
    }

    public int returnKeywordCount() {
        return this.keywordCount;
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
}
