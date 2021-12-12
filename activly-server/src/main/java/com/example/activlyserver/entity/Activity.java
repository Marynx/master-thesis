package com.example.activlyserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner")
    private User owner;
    
    private String discipline;
    
    private String place;
    
    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private Date time;
    
}
