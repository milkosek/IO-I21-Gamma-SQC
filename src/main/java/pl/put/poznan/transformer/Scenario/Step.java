package pl.put.poznan.transformer.Scenario;

public class Step implements ScenarioPart{

    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    private String step;

    public Step(String s){
        this.step = s;
    }

    public String getStep() {
        return this.step;
    }
}
