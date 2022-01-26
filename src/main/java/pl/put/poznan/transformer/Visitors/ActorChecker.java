package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

import java.util.ArrayList;


public class ActorChecker implements ScenarioPartVisitor {

    private ArrayList<String> unusedActors = new ArrayList<>();

    @Override
    public void visit(Scenario scenario) {

    }

    @Override
    public void visit(Title title) {

    }

    @Override
    public void visit(Actor actor) {
        unusedActors.add(actor.getName());
    }

    @Override
    public void visit(SystemActor systemActor) {
        unusedActors.add(systemActor.getName());
    }

    @Override
    public void visit(Step step) {
        for(String act : unusedActors){
            if(step.getStep().matches("(.*)" + act + "(.*)")){
                unusedActors.remove(act);
                break;
            }
        }
    }

    public String getUnused(){
        String un = "";
        for (String act : unusedActors){
            un += act + "\n";
        }
        return un;
    }
}
