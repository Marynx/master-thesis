package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Activity;
import lombok.extern.slf4j.Slf4j;
import service.ActivityService;
import service.ActivityServiceImpl;
import utils.ApiGatewayResponseUtils;

@Slf4j
public class CreateActivityHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    
    private final ActivityService activityService = new ActivityServiceImpl();
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        try {
            Activity activity = gson.fromJson(apiGatewayProxyRequestEvent.getBody(), Activity.class);
            return ApiGatewayResponseUtils.successResponse(gson.toJson(activityService.createActivity(activity)));
        } catch ( Exception e ) {
            log.error("Error occurred during execution of lambda: " + e.getCause());
            return ApiGatewayResponseUtils.failedResponse("Error occurred during execution of lambda.");
        }
    }
    
}
