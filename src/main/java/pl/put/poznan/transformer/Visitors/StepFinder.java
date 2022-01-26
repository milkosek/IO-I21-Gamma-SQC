package pl.put.poznan.transformer.Visitors;

import pl.put.poznan.transformer.Scenario.*;

public class StepFinder implements ScenarioPartVisitor {

    private int num = 1;
    private int find;
    private int last;
    String ans = "";

    public StepFinder(int find){
        this.find = find;
    }

    @Override
    public void visit(Scenario scenario) {

    }

    @Override
    public void visit(Title title) {

    }

    @Override
    public void visit(Actor actor) {

    }

    @Override
    public void visit(SystemActor systemActor) {

    }

    @Override
    public void visit(Step step) {
        String name = step.getStep();
        if(num == find && !name.matches("^ +.*")){
            ans += name + "ㅤ\n";
        }
        if(!name.matches("^ +.*")){
            last = num;
            ++num;
        }
        else if(last == find){
            ans += name + "ㅤ\n";
        }
    }

    public String getAns() {
        return ans;
    }
}
