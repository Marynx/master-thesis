package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import service.ActivityService;
import service.ActivityServiceImpl;
import utils.ApiGatewayResponseUtils;
import utils.DbUtil;

import java.sql.SQLException;

@Slf4j
public class ListActivityHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    
    private final ActivityService activityService = new ActivityServiceImpl();
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        try {
            activityService = new ActivityServiceImpl(DbUtil.getConnection());
            return ApiGatewayResponseUtils.successResponse(gson.toJson(activityService.getAllActivities()));
        } catch ( Exception e ) {
            log.error("Error occurred during execution of lambda: " + e);
            return ApiGatewayResponseUtils.failedResponse("Error occurred during execution of lambda.");
        } finally {
            try {
                DbUtil.closeConnection();
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }
    }
    
}
