package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import service.ActivityService;
import service.ActivityServiceImpl;
import utils.ApiGatewayResponseUtils;

public class ListActivityHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    private final ActivityService activityService = new ActivityServiceImpl();
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        return ApiGatewayResponseUtils.successResponse(new Gson().toJson(activityService.getAllActivities()));
    }
    
}
