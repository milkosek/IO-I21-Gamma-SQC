package pl.put.poznan.transformer.Scenario;

public interface ScenarioPart {
    public void accept(ScenarioPartVisitor scenarioPartVisitor);
}
