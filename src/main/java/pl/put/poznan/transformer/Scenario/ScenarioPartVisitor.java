package pl.put.poznan.transformer.Scenario;

public interface ScenarioPartVisitor {
    public void visit(Scenario scenario);
    public void visit(Title title);
    public void visit(Actor actor);
    public void visit(SystemActor systemActor);
    public void visit(Step step);
}
