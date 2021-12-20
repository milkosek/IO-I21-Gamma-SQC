package pl.put.poznan.transformer.Scenario;

public class SystemActor implements ScenarioPart{

    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    private String name;

    public SystemActor(String n){
        this.name = n;
    }

    public String getName() {
        return this.name;
    }
}
