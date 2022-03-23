package com.example.activlyserverdynamodb.service;

import com.example.activlyserverdynamodb.entity.Activity;
import com.example.activlyserverdynamodb.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{
    
    private final ActivityRepository activityRepository;
    
    
    @Override
    public Activity createActivity(Activity activity) {
        return null;
    }
    
    @Override
    public Activity getActivity(Long id) {
        return null;
    }
    
    @Override
    public void updateActivity(Long id, Activity activity) {
    
    }
    
    @Override
    public boolean deleteActivity(Long id) {
        return false;
    }
    
    @Override
    public List<Activity> getAllActivities() {
        return (List<Activity>) activityRepository.findAll();
    }
    
}
