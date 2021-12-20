package pl.put.poznan.transformer.Scenario;

public class Title implements ScenarioPart{

    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    private String title;

    public Title(String t){
        this.title = t;
    }

    public String getTitle() {
        return this.title;
    }
}
