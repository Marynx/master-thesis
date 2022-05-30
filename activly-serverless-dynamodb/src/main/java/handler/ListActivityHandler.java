package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import service.ActivityService;
import service.ActivityServiceImpl;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import utils.ApiGatewayResponseUtils;

public class ListActivityHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private static final ActivityService ACTIVITY_SERVICE = initActivity();
    
    static {
        ACTIVITY_SERVICE.warmUp();
    }
    
    private static ActivityServiceImpl initActivity(){
        return new ActivityServiceImpl();
    }
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        return ApiGatewayResponseUtils.successResponse(new Gson().toJson(ACTIVITY_SERVICE.getAllActivities()));
    }
    
}
