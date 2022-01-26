package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.Scenario.Scenario;
import pl.put.poznan.transformer.logic.ScenarioQualityChecker;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
@RequestMapping("/{text}")
public class ScenarioQualityCheckerController {

    private static final Logger logger = LoggerFactory.getLogger(ScenarioQualityCheckerController.class);

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text,
                       @RequestBody Scenario transforms,
                       @RequestParam(required = false) Integer depth,
                       @RequestParam(required = false) String arg1,
                       @RequestParam(required = false) Integer step,
                       HttpServletResponse response) {

        // log the parameters
        logger.debug(text);

        // perform the transformation, you should run your logic here, below is just a silly example

        ScenarioQualityChecker transformer;

        // pass the correct parameters
        if (depth != null) {
            transformer = new ScenarioQualityChecker(transforms, depth);
        }
        else if (arg1 != null) {
            transformer = new ScenarioQualityChecker(transforms, arg1);
        }
        else if (step != null){
            transformer = new ScenarioQualityChecker(transforms, step);
        }
        else {
            transformer = new ScenarioQualityChecker(transforms);
        }

        try {
            return transformer.transform(text, response);
        } catch (IOException e) {
            return "Error sending file";
        }
    }

}


