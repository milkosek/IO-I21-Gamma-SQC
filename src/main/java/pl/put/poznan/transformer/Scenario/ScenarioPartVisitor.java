package pl.put.poznan.transformer.Scenario;

/**
 * The ScenarioPartVisitor interface provides
 * the visit methods for all visitor classes.
 */
public interface ScenarioPartVisitor {
    /**
     * This method allows visitors to visit Scenario class.
     * @param scenario Scenario object
     */
    public void visit(Scenario scenario);

    /**
     * This method allows visitors to visit Title class.
     * @param title Title object
     */
    public void visit(Title title);

    /**
     * This method allows visitors to visit Actor class.
     * @param actor Actor object
     */
    public void visit(Actor actor);

    /**
     * This method allows visitors to visit SystemActor class.
     * @param systemActor SystemActor object
     */
    public void visit(SystemActor systemActor);

    /**
     * This method allows visitors to visit Step class.
     * @param step Step object
     */
    public void visit(Step step);
}
