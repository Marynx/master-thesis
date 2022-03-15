package activitydatabase;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class ActivitySimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080") // Here is the root for all relative URLs
            .acceptHeader("text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0");

    ScenarioBuilder scn = scenario("Scenario 2")
            .exec(http("Get all activities")
                    .get("/activities"))
            .exec(http("Add activities")
                    .post("/activities")
                    .header("Content-Type", "application/json")
                    .header("Accept", "application/json")
                    .body(StringBody(
                            "{\"username\":\"Gatling\",\"discipline\":\"Gatling\",\"place\":\"St.Avenue123\",\"time\":\"2022-01-01 15:00:00\"}")))
            .exec(http("Get activity with id 7")
                    .get("/activities/7"));

    {
        setUp(scn.injectOpen(constantUsersPerSec(perMinute(10d)).during(Duration.ofMinutes(2))).protocols(httpProtocol));
    }

    private static Double perMinute(Double rate){
        return rate /60;
    }
}
