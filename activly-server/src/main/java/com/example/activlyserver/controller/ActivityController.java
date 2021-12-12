package com.example.activlyserver.controller;

import com.example.activlyserver.converter.ActivityConverter;
import com.example.activlyserver.dto.ActivityDTO;
import com.example.activlyserver.entity.Activity;
import com.example.activlyserver.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ActivityService.PREFIX)
@RequiredArgsConstructor
public class ActivityController {
    
    private final ActivityService activityService;
    
    @PostMapping
    public ResponseEntity<ActivityDTO> createActivity(@RequestBody ActivityDTO activityDTO){
        Activity created= activityService.createActivity(activityDTO);
        return ResponseEntity.ok(ActivityConverter.convertToDto(created));
    }
    
    
    @GetMapping(ActivityService.BY_ID)
    public ResponseEntity<ActivityDTO> getActivity(@PathVariable Long id){
        Activity toFind = activityService.getActivity(id,false);
        return ResponseEntity.ok(ActivityConverter.convertToDto(toFind));
    }
    
    @PutMapping(ActivityService.BY_ID)
    public ResponseEntity<ActivityDTO> updateActivity(@PathVariable Long id,@RequestBody ActivityDTO activityDTO){
        Activity updated= activityService.updateActivity(id, activityDTO);
        return ResponseEntity.ok(ActivityConverter.convertToDto(updated));
    }
    
    @DeleteMapping(ActivityService.BY_ID)
    public ResponseEntity<String> deleteActivity(@PathVariable Long id){
        activityService.deleteActivity(id);
        return ResponseEntity.ok("Activity with id: "+id+" has been deleted");
    }
    
    @GetMapping
    public ResponseEntity<List<ActivityDTO>> getActivities(){
        return ResponseEntity.ok(ActivityConverter.convertToDtoList(activityService.getAllActivities()));
    }
    
}
