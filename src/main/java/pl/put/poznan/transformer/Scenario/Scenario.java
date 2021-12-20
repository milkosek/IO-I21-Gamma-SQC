package pl.put.poznan.transformer.Scenario;

import java.util.ArrayList;

public class Scenario implements ScenarioPart{

    @Override
    public void accept(ScenarioPartVisitor scenarioPartVisitor){
        this.title.accept(scenarioPartVisitor);
        for (int i = 0; i < actors.size(); ++i){
            actors.get(i).accept(scenarioPartVisitor);
        }
        for (int i = 0; i < systemActors.size(); ++i){
            systemActors.get(i).accept(scenarioPartVisitor);
        }
        for (int i = 0; i < steps.size(); ++i){
            steps.get(i).accept(scenarioPartVisitor);
        }
        scenarioPartVisitor.visit(this);
    }

    private Title title;
    private ArrayList<Actor> actors = new ArrayList<>();
    private ArrayList<SystemActor> systemActors = new ArrayList<>();
    private ArrayList<Step> steps = new ArrayList<>();

    public Scenario(String title, String[] actors, String[] system_actors, String[] steps){
        this.title = new Title(title);
        for (String act : actors) {
            this.actors.add(new Actor(act));
        }
        for (String act : system_actors) {
            this.systemActors.add(new SystemActor(act));
        }
        for (String step : steps) {
            this.steps.add(new Step(step));
        }
    }

    public String getTitle(){
        return this.title.getTitle();
    }

    public String getSystem_actor(int i){
        return this.systemActors.get(i).getName();
    }
    public String getActor(int i){
        return this.actors.get(i).getName();
    }
    public String getNthStep(int i){
        return this.steps.get(i).getStep();
    }
    public ArrayList<Step> getSteps(){
        return this.steps;
    }

    public String getAll(){
        return this.getTitle() + "\n" + this.getActor(0) + "\n";
    }
}
