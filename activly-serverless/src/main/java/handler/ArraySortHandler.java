package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import lombok.extern.slf4j.Slf4j;
import utils.ApiGatewayResponseUtils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class ArraySortHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        int size = Integer.parseInt(apiGatewayProxyRequestEvent.getPathParameters().get("number"));
        int[] numbersToSort = new int[size];
    
        for ( int i = 0; i < size; i++ ) {
            numbersToSort[i] = ThreadLocalRandom.current().nextInt(0, size);
        }
        Arrays.sort(numbersToSort);
        return ApiGatewayResponseUtils.successResponse("List has been sorted");
    }
    
}
