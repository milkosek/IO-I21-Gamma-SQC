package pl.put.poznan.transformer.Scenario;

import java.util.ArrayList;

/**
 * The Scenario class catalogs all the element classes of a given scenario.
 * This class also allows visitor classes to visit every scenario element.
 */
public class Scenario implements ScenarioPart{

    /**
     * This method allows visitor classes to visit every cataloged element class of a scenario.
     * @param scenarioPartVisitor Accepts any Visitor object implementing ScenarioPartVisitor interface
     */
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

    /**
     * The Scenario constructor creates all necessary scenario element classes.
     * @param title Title object
     * @param actors Actor object
     * @param system_actors SystemActor object
     * @param steps Step object
     */
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

    /**
     * Standard getter method.
     * @return Title of scenario
     */
    public String getTitle(){
        return this.title.getTitle();
    }

    /**
     * Standard getter method.
     * @param i The index of a system actor
     * @return The i'th system actor of a scenario
     */
    public String getSystem_actor(int i){
        return this.systemActors.get(i).getName();
    }

    /**
     * Standard getter method.
     * @param i The index of an actor
     * @return The i'th actor of scenario
     */
    public String getActor(int i){
        return this.actors.get(i).getName();
    }

    /**
     * Standard getter method.
     * @param i The index of a step
     * @return The i'th step of a scenario
     */
    public String getNthStep(int i){
        return this.steps.get(i).getStep();
    }

    /**
     * Standard getter method.
     * @return Full ArrayList of scenario steps
     */
    public ArrayList<Step> getSteps(){
        return this.steps;
    }

    /**
     * This method concatenates every step name into a single String.
     * @return String containing every step of a scenario
     */
    public String getAllSteps(){
        String answer = "";
        for (Step step : getSteps()) {
            //System.out.println(step.getStep());
            // "\n" doesn't work on strings ending with ":"?!
            answer += step.getStep() + "\n";
        }
        return answer;
    }
}
