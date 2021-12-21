package pl.put.poznan.transformer.Scenario;

public class Step implements ScenarioPart{

    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    private String step;
    private int depth;

    public Step(String s, int depth){
        this.step = s;
        this.depth = depth;
    }

    public String getStep() {
        return this.step;
    }

    public int getDepth() {
        return this.depth;
    }
}
