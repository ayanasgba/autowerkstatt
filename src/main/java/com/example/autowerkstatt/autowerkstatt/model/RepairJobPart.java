package com.example.autowerkstatt.autowerkstatt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "repair_job_parts",
        uniqueConstraints = @UniqueConstraint(columnNames = {"job_id", "part_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RepairJobPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private RepairJob repairJob;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "part_id", nullable = false)
    private Part part;

    @Column(nullable = false)
    private Integer quantity;
}
