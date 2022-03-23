package com.example.activlyserverdynamodb.controller;

import com.example.activlyserverdynamodb.entity.Activity;
import com.example.activlyserverdynamodb.service.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ActivityService.PREFIX)
@RequiredArgsConstructor
public class ActivityController {
    
    private final ActivityService activityService;
    
    @GetMapping
    public ResponseEntity<List<Activity>> getActivities(){
        return ResponseEntity.ok(activityService.getAllActivities());
    }
    
}
