package com.example.activlyserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    
    private String password;
    
    @Column(unique = true, nullable = false)
    @Email
    private String email;
    
    @Column(unique = true, nullable = false)
    @Pattern(regexp="(^$|[0-9]{9})")
    private String phoneNumber;
    
    @OneToMany(targetEntity = Activity.class, mappedBy = "owner", cascade = {CascadeType.ALL})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private Set<Activity> activities = new HashSet<>();
    
}
