package com.example.autowerkstatt.autowerkstatt.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "mechanic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mechanicId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String specialization;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "mechanic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RepairJob> repairJobs;
}

