package service;

import entity.Activity;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import utils.DynamoDBAdapter;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityServiceImpl implements ActivityService{
    
    private DynamoDBAdapter dbAdapter;
    
    private DynamoDbEnhancedClient enhancedClient;
    
    public ActivityServiceImpl() {
        this.dbAdapter = DynamoDBAdapter.getInstance();
        this.enhancedClient = dbAdapter.createEnhancedDbClient();
    }
    
    @Override
    public List<Activity> getAllActivities() {
        DynamoDbTable<Activity> activityTable = enhancedClient.table("Activity", TableSchema.fromBean(Activity.class));
        List<Activity> activities = activityTable.scan().items().stream().collect(Collectors.toList());
        return activities;
    }
    
    @Override
    public void warmUp() {
        DynamoDbTable<Activity> activityTable = enhancedClient.table("Activity", TableSchema.fromBean(Activity.class));
        activityTable.getItem(Key.builder().partitionValue("2").build());
    }
    
}
