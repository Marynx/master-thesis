package service;

import entity.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> getAllActivities();
    
    void warmUp();
    
}
