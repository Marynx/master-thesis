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
    
    //    ("https://f06fhigrqk.execute-api.us-east-1.amazonaws.com/dev"
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://9ydeglo334.execute-api.us-east-1.amazonaws.com/dev") // Here is the root for all relative URLs
            .acceptHeader("text/html,application/xhtml+xml,application/json,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
            .acceptEncodingHeader("gzip, deflate")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0");
    
 
    
    ScenarioBuilder scn = scenario("Scenario Java 128")
//            .exec(http("Sort Lambda Java 128") // Here's an example of a POST request
//                    .get("/sortNumbersJava128/" + 5000))
//            .pause(Duration.ofMillis(2))
//            .exec(http("Sort Lambda Java 512") // Here's an example of a POST request
//                    .get("/sortNumbersJava512/" + 5000))
//            .pause(Duration.ofMillis(2))
//            .exec(http("Sort Lambda Java 1024") // Here's an example of a POST request
//                    .get("/sortNumbersJava1024/" + 5000));
            .repeat(201, "n")
            .on(
            exec(session -> {
                int number = session.getInt("n") * 5000;
                return session.set("number", number);
            })
                    .exec(http("Sort Lambda Java 128 ") // Here's an example of a POST request
                            .get("/sortNumbersJava128/#{number}"))
                    .exec(http("Sort Lambda Java 512") // Here's an example of a POST request
                            .get("/sortNumbersJava512/#{number}"))
                    .exec(http("Sort Lambda Java 1024") // Here's an example of a POST request
                            .get("/sortNumbersJava1024/#{number}"))
                    .pause(2)
    );
    
//    {
//        setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
//    }
    
    private List<Integer> generateList(int n) {
        List<Integer> list = new ArrayList<>();
        
        for ( int i = 0; i < n; i++ ) {
            int randInt = ThreadLocalRandom.current().nextInt(0, n);
            list.add(randInt);
        }
        return list;
    }
    
}