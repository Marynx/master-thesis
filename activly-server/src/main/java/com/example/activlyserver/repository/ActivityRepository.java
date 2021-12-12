package com.example.activlyserver.repository;

import com.example.activlyserver.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository  extends JpaRepository<Activity, Long> {
}
