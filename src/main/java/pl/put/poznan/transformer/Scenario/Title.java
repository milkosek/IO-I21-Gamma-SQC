package pl.put.poznan.transformer.Scenario;

/**
 * The Title class stores the scenario title
 */
public class Title implements ScenarioPart{

    /**
     * This method allows visitor classes to visit the title.
     * @param scenarioPartVisitor Accepts any Visitor object implementing ScenarioPartVisitor interface
     */
    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    /**
     * Contains title of scenario.
     */
    private String title;

    /**
     * Initializes title variable.
     * @param t Scenario title
     */
    public Title(String t){
        this.title = t;
    }

    /**
     * Standard getter.
     * @return Scenario title
     */
    public String getTitle() {
        return this.title;
    }
}
