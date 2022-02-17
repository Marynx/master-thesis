package com.example.activlyserver.converter;

import com.example.activlyserver.dto.ActivityDTO;
import com.example.activlyserver.entity.Activity;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ActivityConverter {
    
    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public static ActivityDTO convertToDto(Activity activity){
        return new ActivityDTO(activity.getUsername(), activity.getDiscipline(), activity.getDiscipline(),  FORMATTER.format(activity.getTime()));
    }
    
    public static List<ActivityDTO> convertToDtoList(List<Activity> activities){
        return activities.stream().map(ActivityConverter::convertToDto).collect(Collectors.toList());
    }
    
    
}
