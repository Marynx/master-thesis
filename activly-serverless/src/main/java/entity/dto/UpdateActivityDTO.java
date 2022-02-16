package entity.dto;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class UpdateActivityDTO {
    
    String discipline;
    
    String place;
    
    Timestamp time;
    
}
