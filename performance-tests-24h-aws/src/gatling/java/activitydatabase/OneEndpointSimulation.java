package activitydatabase;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class OneEndpointSimulation extends Simulation {
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("url") // Here is the root for all relative URLs
            .acceptHeader("text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0");
    
    
    ScenarioBuilder scn0 = scenario("Record Cold/Start 1 Minutes")
            .repeat(240)
            .on(
                    exec(http("Cold Start Record 1 Minutes")
                            .get("/1minute"))
                            .pause(Duration.ofMinutes(1))
            );
    
    
    ScenarioBuilder scn = scenario("Record Cold/Start 2 Minutes")
            .repeat(120)
            .on(
                exec(http("Cold Start Record 2 Minutes")
                    .get("/2minutes"))
                        .pause(Duration.ofMinutes(2))
            );
    
    ScenarioBuilder scn1 = scenario("Record Cold/Start 3 Minutes")
            .repeat(80)
            .on(
                    exec(http("Cold Start Record 3 Minutes")
                            .get("/3minutes"))
                            .pause(Duration.ofMinutes(3))
            );
    
    ScenarioBuilder scn2 = scenario("Record Cold/Start 4 Minutes")
            .repeat(60)
            .on(
                    exec(http("Cold Start Record 4 Minutes")
                            .get("/4minutes"))
                            .pause(Duration.ofMinutes(4))
            );
    
    ScenarioBuilder scn3 = scenario("Record Cold/Start 5 Minutes")
            .repeat(48)
            .on(
                    exec(http("Cold Start Record 5 Minutes")
                            .get("/20minutes"))
                            .pause(Duration.ofMinutes(5))
            );
    
    
    ScenarioBuilder scn4 = scenario("Record Cold/Start 6 Minutes")
            .repeat(40)
            .on(
                    exec(http("Cold Start Record 6 Minutes")
                            .get("/25minutes"))
                            .pause(Duration.ofMinutes(6))
            );
    
    
    ScenarioBuilder scn5 = scenario("Record Cold/Start 7 Minutes")
            .repeat(35)
            .on(
                    exec(http("Cold Start Record 7 Minutes")
                            .get("/30minutes"))
                            .pause(Duration.ofMinutes(7))
            );
    
    ScenarioBuilder scn6 = scenario("Record Cold/Start 8 Minutes")
            .repeat(30)
            .on(
                    exec(http("Cold Start Record 8 Minutes")
                            .get("/8minutes"))
                            .pause(Duration.ofMinutes(8))
            );
    
   
    
    {
        setUp(
                scn0.injectOpen(atOnceUsers(1)),
                scn.injectOpen(atOnceUsers(1)),
                scn1.injectOpen(atOnceUsers(1)),
                scn2.injectOpen(atOnceUsers(1)),
                scn3.injectOpen(atOnceUsers(1)),
                scn4.injectOpen(atOnceUsers(1)),
                scn5.injectOpen(atOnceUsers(1)),
                scn6.injectOpen(atOnceUsers(1))
                ).protocols(httpProtocol);
    }

}
