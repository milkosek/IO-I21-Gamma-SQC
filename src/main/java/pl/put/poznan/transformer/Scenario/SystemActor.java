package pl.put.poznan.transformer.Scenario;

/**
 * The SystemActor class stores the name of a single system actor
 * declared in the scenario
 */
public class SystemActor implements ScenarioPart{

    /**
     * This method allows visitor classes to visit the system actor.
     * @param scenarioPartVisitor Accepts any Visitor object implementing ScenarioPartVisitor interface
     */
    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    /**
     * Contains name of a system actor.
     */
    private String name;

    /**
     * Initializes name variable.
     * @param n System actor's name
     */
    public SystemActor(String n){
        this.name = n;
    }

    /**
     * Standard getter.
     * @return Name of system actor
     */
    public String getName() {
        return this.name;
    }
}
