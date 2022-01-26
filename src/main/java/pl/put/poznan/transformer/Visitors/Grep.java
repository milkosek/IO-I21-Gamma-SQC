package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

import java.util.ArrayList;

public class Grep implements ScenarioPartVisitor {

    private ArrayList<Step> found = new ArrayList<>();
    private String search;


    public void setWord(String search) {
        this.search = search;
    }

    @Override
    public void visit(Scenario scenario) {}

    @Override
    public void visit(Step step) {
        String text = step.getStep().trim();
        if (text.matches("(?i).*" + search + ".*")) {
            found.add(step);
        }
    }

    public String getFound(){
        String answer = "";

        for (Step step : found) {
            //System.out.println(step.getStep());
            // "\n" doesn't work on strings ending with ":"?!
            // workaround using with "ㅤ" symbol (u+3164)
            answer += step.getStep() + "ㅤ\n";
        }
        return answer;
    }

    @Override
    public void visit(Title title) {}

    @Override
    public void visit(Actor actor) {}

    @Override
    public void visit(SystemActor systemActor) {}
}
