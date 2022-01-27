package pl.put.poznan.transformer.Scenario;

/**
 * The Actor class stores the name of a single actor
 * declared in the scenario
 */
public class Actor implements ScenarioPart{

    /**
     * This method allows visitor classes to visit the actor.
     * @param scenarioPartVisitor Accepts any Visitor object implementing ScenarioPartVisitor interface
     */
    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    /**
     * Contains name of an actor.
     */
    private String name;

    /**
     * Initializes name variable.
     * @param n Actor's name
     */
    public Actor(String n){
        this.name = n;
    }

    /**
     * Standard getter.
     * @return Name of actor
     */
    public String getName() {
        return this.name;
    }
}
