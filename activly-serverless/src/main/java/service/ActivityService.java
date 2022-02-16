package service;

import entity.Activity;
import exception.ActivityDatabaseOperationException;

import java.util.List;

public interface ActivityService {
    
    Activity createActivity(Activity activity) throws ActivityDatabaseOperationException;
    
    Activity getActivity(Long id) throws ActivityDatabaseOperationException;
    
    void updateActivity(Long id, Activity activity);
    
    boolean deleteActivity(Long id);
    
    List<Activity> getAllActivities();
    
}
