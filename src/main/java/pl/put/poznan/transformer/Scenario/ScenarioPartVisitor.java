package pl.put.poznan.transformer.Scenario;

/**
 * The ScenarioPartVisitor interface provides
 * the visit methods for all visitor classes.
 */
public interface ScenarioPartVisitor {
    /**
     * This method allows visitors to visit Scenario class.
     * @param scenario
     */
    public void visit(Scenario scenario);

    /**
     * This method allows visitors to visit Title class.
     * @param title
     */
    public void visit(Title title);

    /**
     * This method allows visitors to visit Actor class.
     * @param actor
     */
    public void visit(Actor actor);

    /**
     * This method allows visitors to visit SystemActor class.
     * @param systemActor
     */
    public void visit(SystemActor systemActor);

    /**
     * This method allows visitors to visit Step class.
     * @param step
     */
    public void visit(Step step);
}
