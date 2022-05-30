package utils;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import java.util.Collections;
import java.util.Map;

public class ApiGatewayResponseUtils {
    
    private static final Map<String, String> RESPONSE_HEADERS = Collections.singletonMap("Content-type", "application/json");
    
    public static APIGatewayProxyResponseEvent successResponse(String responseBody){
        return new APIGatewayProxyResponseEvent()
                .withBody(responseBody)
                .withStatusCode(200)
                .withHeaders(RESPONSE_HEADERS)
                .withIsBase64Encoded(false);
    }
    
    public static APIGatewayProxyResponseEvent failedResponse(String responseBody){
        return new APIGatewayProxyResponseEvent()
                .withBody(responseBody)
                .withStatusCode(400)
                .withHeaders(RESPONSE_HEADERS)
                .withIsBase64Encoded(false);
    }
    
    
}
