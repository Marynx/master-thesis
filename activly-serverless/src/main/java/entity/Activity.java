package entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Activity {
    
    private Long id;

    private String username;
    
    private String discipline;
    
    private String place;
    
    private Timestamp time;

}
