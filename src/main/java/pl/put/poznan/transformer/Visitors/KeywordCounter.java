package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

public class KeywordCounter implements ScenarioPartVisitor {
    private int keywordCount = 0;

    @Override
    public void visit(Scenario scenario) {}

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

    public int getKeywordCount() {
        return this.keywordCount;
    }

    @Override
    public void visit(Title title) {}

    @Override
    public void visit(Actor actor) {}

    @Override
    public void visit(SystemActor systemActor) {}
}
