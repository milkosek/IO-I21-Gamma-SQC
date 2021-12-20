package pl.put.poznan.transformer.logic;

import org.hamcrest.Condition;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JSONparser {

//    private final Scenario scenario;
    private String filepath;

    public JSONparser(String file){
        this.filepath = file;
    }

    public static void main(String[] args) {
        List<Scenario> scenarios = new ArrayList<Scenario>();
        scenarios = readJSONscenario("src/main/resources/text2.json");
        scenarios.forEach( scenario -> scenario.printScenario() );
    }

    @SuppressWarnings("unchecked")
    public static List<Scenario> readJSONscenario(String args)
    {
        JSONParser jsonParser = new JSONParser();
        List<Scenario> scenarios = new ArrayList<Scenario>();

        try (FileReader reader = new FileReader(args))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray scenarioJSON = (JSONArray) obj;

            scenarioJSON.forEach( scenario -> scenarios.add(parseScenarioObject( (JSONObject) scenario )) );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scenarios;
    }

    private static Scenario parseScenarioObject(JSONObject scenarioObject)
    {
        String title = (String) scenarioObject.get("Tytuł");

        String actors = (String) scenarioObject.get("Aktorzy");

        String sysActor = (String) scenarioObject.get("Aktor systemowy");

        Scenario nScen = new Scenario(title, actors, sysActor);

        JSONArray steps = (JSONArray) scenarioObject.get("steps");
        steps.forEach( step -> parseStep( (JSONObject) step, nScen, 0) );

        return nScen;
    }

    private static void parseStep(JSONObject step, Scenario scen, int depth)
    {
        String text = (String) step.get("text");

        String keyword = keywordReader(text);

        scen.addStep(text, keyword, depth);

        if (!keyword.equals("")) {
            JSONArray substeps = (JSONArray) step.get("substeps");
            substeps.forEach( sstep -> parseStep( (JSONObject) sstep, scen, (depth + 1)) );
        }
    };

    private static String keywordReader ( String text) {
        String[] s = text.split(":", 2);
        if (s.length == 2) {
            return s[0];
        }
        else {
            return "";
        }
    };
}
