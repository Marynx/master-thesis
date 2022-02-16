package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Activity;
import entity.dto.UpdateActivityDTO;
import lombok.extern.slf4j.Slf4j;
import service.ActivityService;
import service.ActivityServiceImpl;
import utils.ApiGatewayResponseUtils;

@Slf4j
public class UpdateActivityHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    
    private final ActivityService activityService = new ActivityServiceImpl();
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        try {
            String activityId = apiGatewayProxyRequestEvent.getPathParameters().get("id");
            UpdateActivityDTO activityFromRequest = gson.fromJson(apiGatewayProxyRequestEvent.getBody(), UpdateActivityDTO.class);
            Activity activityToUpdate = activityService.getActivity(Long.valueOf(activityId));
            if ( activityToUpdate != null ) {
                activityToUpdate.setDiscipline(activityFromRequest.getDiscipline());
                activityToUpdate.setPlace(activityFromRequest.getPlace());
                activityToUpdate.setTime(activityFromRequest.getTime());
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
