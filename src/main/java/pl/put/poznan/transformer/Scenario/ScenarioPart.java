package pl.put.poznan.transformer.Scenario;

/**
 * The ScenarioPart interface provides the accept method
 * used by Scenario class and every scenario element class.
 */
public interface ScenarioPart {
    /**
     * This method allows the visitor classes to interact
     * with the scenario element classes.
     * @param scenarioPartVisitor This is the only parameter to accept method
     */
    public void accept(ScenarioPartVisitor scenarioPartVisitor);
}
