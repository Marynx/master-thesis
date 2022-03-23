package com.example.activlyserverdynamodb.repository;

import com.example.activlyserverdynamodb.entity.Activity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ActivityRepository extends CrudRepository<Activity, String> {
    
    Optional<Activity> findById(String id);

}
