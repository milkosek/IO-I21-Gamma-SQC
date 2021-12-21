package pl.put.poznan.transformer.Scenario;

public class Step implements ScenarioPart{

    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        scenarioPartVisitor.visit(this);
    }

    private String step;
    private int depth;

    public Step(String s){
        this.step = s;
    }

    public String getStep() {
        return this.step;
    }

    public void setStep(String text) {
        this.step = text;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }
}
