package entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Activity {
    
    private Long id;

    private String username;
    
    private String discipline;
    
    private String place;
    
    private Date time;

}
