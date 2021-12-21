package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

import java.util.ArrayList;

public class MistakeCounter implements ScenarioPartVisitor {

    private ArrayList<String> actors = new ArrayList<>();
    private ArrayList<String> mistakes = new ArrayList<>();

    @Override
    public void visit(Scenario scenario) {

    }

    @Override
    public void visit(Title title) {

    }

    @Override
    public void visit(Actor actor) {
        actors.add(actor.getName());
    }

    @Override
    public void visit(SystemActor systemActor) {
        actors.add(systemActor.getName());
    }

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

    public String getMistakes(){
        String mistake = "";
        for (String mist : mistakes) {
            mistake += mist + "\n";
        }
        return mistake;
    }

}
