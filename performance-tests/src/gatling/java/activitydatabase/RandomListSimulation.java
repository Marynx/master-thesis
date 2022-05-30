package activitydatabase;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.http.HttpDsl.http;

public class RandomListSimulation extends Simulation {
    
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("url") // Here is the root for all relative URLs
            .acceptHeader("text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0");
    
    ScenarioBuilder scn = scenario("Scenario Java 128")
            .repeat(201, "n")
            .on(
                    exec(session -> {
                        int number = session.getInt("n") * 5000;
                        return session.set("number", number);
                    })
                            .exec(http("Sort Lambda Java 128 ")
                                    .get("/sortNumbersJava128/#{number}"))
                            .exec(http("Sort Lambda Java 512")
                                    .get("/sortNumbersJava512/#{number}"))
                            .exec(http("Sort Lambda Java 1024")
                                    .get("/sortNumbersJava1024/#{number}"))
                            .pause(2)
            );
    
    {
        setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
    }
    
}