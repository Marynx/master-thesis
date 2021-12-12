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
    
    private static final String TIME_FORMAT = "dd-MM-yyyy HH:mm";
    
    private final ActivityRepository activityRepository;
    
    private final AuthProvider authProvider;
    
    @Override
    public Activity createActivity(ActivityDTO activityDTO) {
        Activity activity = updateFromDto(new Activity(), activityDTO);
        activity.setOwner(authProvider.getUserEntity());
        return activityRepository.save(activity);
    }
    
    @Override
    public Activity getActivity(@NonNull Long id, boolean validateOwner) {
        String owner = authProvider.getUserLogin();
        Activity activity = activityRepository.findById(id).orElseThrow(() -> new ViolationException("id", "Activity for " + id + " not found"));
        if ( validateOwner && !activity.getOwner().getUsername().equals(owner) ) {
            throw new ViolationException("owner", "Activity is not yours");
        }
        return activity;
    }
    
    @Override
    public Activity updateActivity(@NonNull Long id, ActivityDTO activityDTO){
        Activity toUpdate = updateFromDto(getActivity(id, true),activityDTO);
        return activityRepository.save(toUpdate);
    }
    
    @Override
    public void deleteActivity(@NonNull Long id) {
        Activity toDelete = getActivity(id, true);
        activityRepository.delete(toDelete);
    }
    
    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
    
    private Activity updateFromDto(Activity activity, ActivityDTO activityDTO){
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
