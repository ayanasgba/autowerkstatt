package com.example.autowerkstatt.autowerkstatt.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private RepairJob repairJob;

    @Column(nullable = false)
    private LocalDateTime invoiceDate;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private String paidStatus;
}
