package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

import java.util.ArrayList;

/**
 * The ActorChecker class checks whether
 * every actor declared to be in the scenario is actually used.
 */
public class ActorChecker implements ScenarioPartVisitor {

    /**
     * Stores an ArrayList of unused actors.
     */
    private ArrayList<String> unusedActors = new ArrayList<>();

    /**
     * Unused.
     * @param scenario Scenario object
     */
    @Override
    public void visit(Scenario scenario) {

    }

    /**
     * Unused.
     * @param title Title object
     */
    @Override
    public void visit(Title title) {

    }

    /**
     * Puts every actor name inside ArrayList unusedActors
     * @param actor Actor object
     */
    @Override
    public void visit(Actor actor) {
        unusedActors.add(actor.getName());
    }

    /**
     * Puts every system actor name inside ArrayList unusedActors
     * @param systemActor SystemActor object
     */
    @Override
    public void visit(SystemActor systemActor) {
        unusedActors.add(systemActor.getName());
    }

    /**
     * Checks if any of the actors are a part of a step
     * @param step Step object
     */
    @Override
    public void visit(Step step) {
        for(String act : unusedActors){
            if(step.getStep().matches("(.*)" + act + "(.*)")){
                unusedActors.remove(act);
                break;
            }
        }
    }

    /**
     * Standard getter method.
     * @return String containing all unused actors' names
     */
    public String getUnused(){
        String un = "";
        for (String act : unusedActors){
            un += act + "\n";
        }
        return un;
    }
}
