package activitydatabase;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class OneEndpointSimulation extends Simulation {
//    ("https://f06fhigrqk.execute-api.us-east-1.amazonaws.com/dev" Serverless RDS
//    ("https://8zaaqkjux4.execute-api.us-east-1.amazonaws.com/dev" Serverless DynamoDB
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://z06lh1xjfl.execute-api.us-east-1.amazonaws.com/dev") // Here is the root for all relative URLs
            .acceptHeader("text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0");
    
    ScenarioBuilder scn = scenario("Record Cold/Start 5 Minutes")
            .repeat(288)
            .on(
                exec(http("Cold Start Record 5 Minutes")
                    .get("/5minutes"))
                        .pause(Duration.ofMinutes(5))
            );
    
    ScenarioBuilder scn1 = scenario("Record Cold/Start 10 Minutes")
            .repeat(144)
            .on(
                    exec(http("Cold Start Record 10 Minutes")
                            .get("/10minutes"))
                            .pause(Duration.ofMinutes(10))
            );
    
    ScenarioBuilder scn2 = scenario("Record Cold/Start 15 Minutes")
            .repeat(96)
            .on(
                    exec(http("Cold Start Record 15 Minutes")
                            .get("/15minutes"))
                            .pause(Duration.ofMinutes(15))
            );
    
    ScenarioBuilder scn3 = scenario("Record Cold/Start 20 Minutes")
            .repeat(72)
            .on(
                    exec(http("Cold Start Record 20 Minutes")
                            .get("/20minutes"))
                            .pause(Duration.ofMinutes(20))
            );
    
    
    ScenarioBuilder scn4 = scenario("Record Cold/Start 25 Minutes")
            .repeat(58)
            .on(
                    exec(http("Cold Start Record 25 Minutes")
                            .get("/25minutes"))
                            .pause(Duration.ofMinutes(25))
            );
    
    
    ScenarioBuilder scn5 = scenario("Record Cold/Start 30 Minutes")
            .repeat(48)
            .on(
                    exec(http("Cold Start Record 30 Minutes")
                            .get("/30minutes"))
                            .pause(Duration.ofMinutes(30))
            );
    
   
    
    {
        setUp(scn.injectOpen(atOnceUsers(1)),
                scn1.injectOpen(atOnceUsers(1)),
                scn2.injectOpen(atOnceUsers(1)),
                scn3.injectOpen(atOnceUsers(1)),
                scn4.injectOpen(atOnceUsers(1)),
                scn5.injectOpen(atOnceUsers(1))
        ).protocols(httpProtocol);
    }

}
