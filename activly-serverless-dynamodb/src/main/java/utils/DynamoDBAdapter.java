package utils;

import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.HttpURLConnection;

public class DynamoDBAdapter {
    
    private static DynamoDBAdapter dbAdapter = null;
    
    private final DynamoDbClient client;
    
    private DynamoDbEnhancedClient enhancedClient;
    
    private DynamoDBAdapter() {
        this.client = DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .httpClientBuilder(UrlConnectionHttpClient.builder())
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();
    }
    
    public static DynamoDBAdapter getInstance() {
        if ( dbAdapter == null ) {
            dbAdapter = new DynamoDBAdapter();
        }
        
        return dbAdapter;
    }
    
    public DynamoDbClient getDbClient() {
        return this.client;
    }
    
    public DynamoDbEnhancedClient createEnhancedDbClient() {
        if ( this.client != null ) {
            enhancedClient = DynamoDbEnhancedClient.builder().
            dynamoDbClient(this.client).build();
        }
        
        return this.enhancedClient;
    }
    
}
