package service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import entity.Activity;
import utils.DynamoDBAdapter;

import java.util.List;

public class ActivityServiceImpl implements ActivityService{
    
    private DynamoDBAdapter dbAdapter;
    
    private AmazonDynamoDB client;
    
    private DynamoDBMapper mapper;
    
    public ActivityServiceImpl() {
        
        DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig.builder()
                .withTableNameOverride(new DynamoDBMapperConfig.TableNameOverride("Activity"))
                .build();
        this.dbAdapter = DynamoDBAdapter.getInstance();
        this.client = dbAdapter.getDbClient();
        this.mapper = dbAdapter.createDbMapper(mapperConfig);
    }
    
    @Override
    public List<Activity> getAllActivities() {
        return mapper.scan(Activity.class, new DynamoDBScanExpression());
    }
    
}
