package pl.put.poznan.transformer.Scenario;

/**
 * The Step class stores information
 * about a single step of a scenario
 */
public class Step implements ScenarioPart{

    /**
     * This method allows visitor classes to visit the step.
     * @param scenarioPartVisitor Accepts any Visitor object implementing ScenarioPartVisitor interface
     */
    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    /**
     * Description of step.
     */
    private String step;
    /**
     * Depth level of step.
     */
    private int depth;

    /**
     * Initializes step variable.
     * @param s Step description
     */
    public Step(String s){
        this.step = s;
    }

    /**
     * Standard getter.
     * @return Description of step
     */
    public String getStep() {
        return this.step;
    }

    /**
     * Standard setter.
     * @param text Description of step.
     */
    public void setStep(String text) {
        this.step = text;
    }

    /**
     * Standard setter.
     * @param depth Depth of step
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Standard getter.
     * @return Level of depth of step
     */
    public int getDepth() {
        return this.depth;
    }
}
