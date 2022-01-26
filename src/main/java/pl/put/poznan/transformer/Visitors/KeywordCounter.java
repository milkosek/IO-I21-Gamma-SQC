package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

/**
 * The KeywordCounter class counts every use of IF, ELSE and FOR EACH
 * in a given scenario.
 */
public class KeywordCounter implements ScenarioPartVisitor {
    /**
     * Number of keywords found
     */
    private int keywordCount = 0;

    /**
     * Unused.
     * @param scenario Scenario object
     */
    @Override
    public void visit(Scenario scenario) {}

    /**
     * Checks if given step name contains one of valid keywords.
     * @param step Step object
     */
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

    /**
     * Standard getter method.
     * @return Number of found keywords in a scenario
     */
    public int getKeywordCount() {
        return this.keywordCount;
    }

    /**
     * Unused.
     * @param title Title object
     */
    @Override
    public void visit(Title title) {}

    /**
     * Unused.
     * @param actor Actor object
     */
    @Override
    public void visit(Actor actor) {}

    /**
     * Unused.
     * @param systemActor SystemActor object
     */
    @Override
    public void visit(SystemActor systemActor) {}
}
