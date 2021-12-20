package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

public class Scenario {
    private String title;
    private String actors;
    private String sysActors;
    private List<Step> steps;

    public Scenario(String title, String actors, String systemActors) {
        this.title = title;
        this.actors = actors;
        this.sysActors = systemActors;
        steps = new ArrayList<Step>();
    };

    private class Step {
        private String text;
        private String keyword;
        private int depth;

        private Step(String text, String keyword, int depth) {
            this.text = text;
            this.keyword = keyword;
            this.depth = depth;
        };

        public int getDepth() {
            return this.depth;
        };
    };

    public void addStep(String text, String keyword, int depth) {
        this.steps.add(new Step(text, keyword, depth));
    }

    public void printScenario() {
        System.out.println("Tytuł: " + this.title);
        System.out.println("Aktorzy: " + this.actors);
        System.out.println("Aktorzy systemowi: " + this.sysActors + "\n");
        for (Step temp : this.steps) {
            System.out.print(new String(new char[temp.depth]).replace("\0", "  "));
            System.out.println(temp.text);
        }
        System.out.println();
    }
}
