package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

import java.util.ArrayList;

/**
 * The MistakeChecker class checks every step of a scenario
 * to find any that do not start with a viable actor.
 */
public class MistakeChecker implements ScenarioPartVisitor {

    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<String> mistakes = new ArrayList<>();

    /**
     * Unused.
     * @param scenario Scenario object
     */
    @Override
    public void visit(Scenario scenario) {}

    /**
     * Unused.
     * @param title Title object
     */
    @Override
    public void visit(Title title) {}

    /**
     * Used to list every viable actor name.
     * @param actor Actor object
     */
    @Override
    public void visit(Actor actor) {
        actors.add(actor.getName());
    }

    /**
     * Used to list every viable system actor name.
     * @param systemActor SystemActor object
     */
    @Override
    public void visit(SystemActor systemActor) {
        actors.add(systemActor.getName());
    }

    /**
     * This method checks whether a step begins with a viable actor's name.
     * @param step Step object
     */
    @Override
    public void visit(Step step) {
        String text = step.getStep().trim();
        if (text.matches("IF.*")) {
            text = text.replaceFirst("IF:", "");
        }
        else if (text.matches("ELSE.*")) {
            text = text.replaceFirst("ELSE:", "");
        }
        else if (text.matches("FOR EACH.*")) {
            return;
        }
        for (String act : actors) {
            if (text.trim().matches(act + ".*")){
                return;
            }
        }
        mistakes.add(step.getStep());
    }

    /**
     * Standard getter method.
     * @return String containing every step of a scenario not starting with an actor's name
     */
    public String getMistakes(){
        String mistake = "";
        for (String mist : mistakes) {
            mistake += mist + "\n";
        }
        return mistake;
    }

}
