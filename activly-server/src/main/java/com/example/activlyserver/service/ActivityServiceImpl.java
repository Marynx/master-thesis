package com.example.activlyserver.service;

import com.example.activlyserver.dto.ActivityDTO;
import com.example.activlyserver.entity.Activity;
import com.example.activlyserver.exception.ViolationException;
import com.example.activlyserver.repository.ActivityRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    private final ActivityRepository activityRepository;
    
    @Override
    public Activity createActivity(ActivityDTO activityDTO) {
        Activity activity = updateFromDto(new Activity(), activityDTO, false);
        return activityRepository.save(activity);
    }
    
    @Override
    public Activity getActivity(@NonNull Long id) {
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ViolationException("id", "Activity for " + id + " not found"));
        return activity;
    }
    
    @Override
    public Activity updateActivity(@NonNull Long id, ActivityDTO activityDTO){
        Activity toUpdate = updateFromDto(getActivity(id),activityDTO, true);
        return activityRepository.save(toUpdate);
    }
    
    @Override
    public void deleteActivity(@NonNull Long id) {
        Activity toDelete = getActivity(id);
        activityRepository.delete(toDelete);
    }
    
    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
    
    private Activity updateFromDto(Activity activity, ActivityDTO activityDTO, boolean isUpdate){
        if(!isUpdate) {
            activity.setUsername(activityDTO.getUsername());
        }
        activity.setDiscipline(activityDTO.getDiscipline());
        activity.setPlace(activityDTO.getPlace());
        try {
            activity.setTime(new SimpleDateFormat(TIME_FORMAT).parse(activityDTO.getTime()));
        } catch ( ParseException e ) {
            throw new ViolationException("time", "Wrong time format");
        }
        return activity;
    }
    
}
