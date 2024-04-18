package pa.com.sura.apisuggestedvalue.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pa.com.sura.apisuggestedvalue.services.CalcSuggestedValueServiceImpl;

@RestController
public class SuggestedValueController {
    @Autowired
    private CalcSuggestedValueServiceImpl suggestedValue;
    private static final Logger logger = LoggerFactory.getLogger(SuggestedValueController.class);
    private static final String RAMO = "ramo";
    private static final String ORIGINAL_CAR_VALUE = "original_value";
    private static final String USE = "use";
    private static final String YEAR = "year";

    @GetMapping("/suggested-value")
    public ResponseEntity<?> getValue(
            @RequestHeader Map<String, String> headers,
            @RequestHeader(name = "x-organization-id") String xOrganizationId,
            @RequestHeader(name = "x-organization-type") String xOrganizationType,
            @RequestHeader(name = "x-client-application") String xClientApplication,
            @RequestHeader(name = "x-client-application-flow", required = false) String xClientApplicationFlow,
            @RequestHeader(name = "x-trace-id") String xTraceId,
            @RequestHeader(name = "x-user") String xUser,
            @RequestParam(name = RAMO) String ramo,
            @RequestParam(name = ORIGINAL_CAR_VALUE) String original_car_value,
            @RequestParam(name = USE) String use,
            @RequestParam(name = YEAR) String year) {

        logger.info("Test");
        Map<String, String> response = new HashMap<>();
        // response=suggestedValue.getSuggestedValueDto("asd", 100, "USE", 2020);
        double original_value = Double.parseDouble(original_car_value);
        int buy_year = Integer.parseInt(year);

        response = suggestedValue.getSuggestedValueDto(ramo, original_value, use, buy_year);
        // logger.debug("Current year: "+result);
        // response.put("currentYear", result.getCurrentYear());
        // response.put("suggestedValue", result.getSuggestedValue());
        // response.put("suggestedValue", "ASD");
        return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
    }

}
