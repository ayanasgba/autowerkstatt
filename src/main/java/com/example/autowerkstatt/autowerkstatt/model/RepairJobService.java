package com.example.autowerkstatt.autowerkstatt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "repair_job_services",
        uniqueConstraints = @UniqueConstraint(columnNames = {"job_id", "service_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RepairJobService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private RepairJob repairJob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(nullable = false)
    private Integer quantity;
}

