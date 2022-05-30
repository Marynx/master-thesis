package entity;


import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Activity {
    
    private String id;
    
    private String username;
    
    private String discipline;
    
    private String place;
    
    private String time;
    
    @DynamoDbPartitionKey
    public String getId() {
        return this.id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getDiscipline() {
        return this.discipline;
    }
    
    public String getPlace() {
        return this.place;
    }
    
    public String getTime() {
        return this.time;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    
    public void setTime(String time) {
        this.time = time;
    }
    
}
