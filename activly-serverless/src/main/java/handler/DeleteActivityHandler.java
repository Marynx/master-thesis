package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import lombok.extern.slf4j.Slf4j;
import service.ActivityService;
import service.ActivityServiceImpl;
import utils.ApiGatewayResponseUtils;

@Slf4j
public class DeleteActivityHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    private final ActivityService activityService = new ActivityServiceImpl();
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        try {
            String activityId = apiGatewayProxyRequestEvent.getPathParameters().get("id");
            boolean deleteSuccess = activityService.deleteActivity(Long.valueOf(activityId));
            if ( deleteSuccess ) {
                return ApiGatewayResponseUtils.successResponse("Activity with id: '"+ activityId +"' has been deleted");
            } else {
                return ApiGatewayResponseUtils.failedResponse("Activity with id: '" + activityId + "' not found.");
            }
        } catch ( Exception e ) {
            log.error("Error occurred during execution of lambda: " + e);
            return ApiGatewayResponseUtils.failedResponse("Error occurred during execution of lambda.");
        }
    }
    
}
