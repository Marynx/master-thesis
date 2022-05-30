package com.example.activlyserverdynamodb.service;

import com.example.activlyserverdynamodb.entity.Activity;

import java.util.List;

public interface ActivityService {
    
    String PREFIX = "/activities";
    
    String BY_ID = "/{id}";
    
    Activity createActivity(Activity activity);
    
    Activity getActivity(Long id);
    
    void updateActivity(Long id, Activity activity);
    
    boolean deleteActivity(Long id);
    
    List<Activity> getAllActivities();
    
}
