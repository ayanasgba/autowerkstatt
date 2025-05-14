package com.example.autowerkstatt.autowerkstatt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "repair_job")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepairJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mechanic_id", nullable = false)
    private Mechanic mechanic;

    @Column(nullable = false)
    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Column(nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @OneToMany(mappedBy = "repairJob", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RepairJobService> repairJobServices;

    @OneToMany(mappedBy = "repairJob", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RepairJobPart> repairJobParts;

    @OneToOne(mappedBy = "repairJob", cascade = CascadeType.ALL, orphanRemoval = true)
    private Invoice invoice;
}
