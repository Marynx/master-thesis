package com.example.activlyserver.service;

import com.example.activlyserver.dto.ActivityDTO;
import com.example.activlyserver.entity.Activity;

import java.util.List;

public interface ActivityService {
    
    String PREFIX = "/activities";
    
    String BY_ID = "/{id}";
    
    Activity createActivity(ActivityDTO activityDTO);
    
    Activity getActivity(Long id);
    
    Activity updateActivity(Long id, ActivityDTO activityDTO);
    
    void deleteActivity(Long id);
    
    List<Activity> getAllActivities();
    
}
