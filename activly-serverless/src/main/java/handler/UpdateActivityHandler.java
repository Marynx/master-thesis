package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Activity;
import lombok.extern.slf4j.Slf4j;
import service.ActivityService;
import service.ActivityServiceImpl;
import utils.ApiGatewayResponseUtils;

import java.sql.Date;

@Slf4j
public class UpdateActivityHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    
    private final ActivityService activityService = new ActivityServiceImpl();
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        try {
            String activityId = apiGatewayProxyRequestEvent.getPathParameters().get("id");
            JsonObject activityFromRequest = gson.fromJson(apiGatewayProxyRequestEvent.getBody(), JsonObject.class);
            Activity activityToUpdate = activityService.getActivity(Long.valueOf(activityId));
            if ( activityToUpdate != null ) {
                activityToUpdate.setDiscipline(activityFromRequest.get("discipline").getAsString());
                activityToUpdate.setPlace(activityFromRequest.get("place").getAsString());
                activityToUpdate.setTime(Date.valueOf(activityFromRequest.get("time").getAsString()));
                activityService.updateActivity(Long.valueOf(activityId), activityToUpdate);
                return ApiGatewayResponseUtils.successResponse(gson.toJson(activityToUpdate));
            } else {
                return ApiGatewayResponseUtils.failedResponse("Activity with id: " + activityId + " not found.");
            }
        } catch ( Exception e ) {
            log.error("Error occurred during execution of lambda: " + e);
            return ApiGatewayResponseUtils.failedResponse("Error occurred during execution of lambda.");
        }
    }
    
}
