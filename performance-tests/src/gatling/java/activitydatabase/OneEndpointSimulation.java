package activitydatabase;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class OneEndpointSimulation extends Simulation {
//    ("https://f06fhigrqk.execute-api.us-east-1.amazonaws.com/dev"
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://f06fhigrqk.execute-api.us-east-1.amazonaws.com/dev") // Here is the root for all relative URLs
            .acceptHeader("text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0");
    
    ScenarioBuilder scn = scenario("Scenario 1 Workload 1")
            .exec(http("Get all activities")
                    .get("/activities"));
    
    
    {
        setUp(scn.injectOpen(atOnceUsers(1),
                        rampUsersPerSec(1).to(60).during(60),
                        constantUsersPerSec(60).during(Duration.ofMinutes(2))
                        ).protocols(httpProtocol)
                );
    }

}
