package com.example.autowerkstatt.autowerkstatt.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal unitCost;

    @Column(nullable = false)
    private Integer stockQty;

    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RepairJobPart> repairJobParts;

    public Part() {
    }

    public Part(Long partId, String name, String description, BigDecimal unitCost, Integer stockQty) {
        this.partId = partId;
        this.name = name;
        this.description = description;
        this.unitCost = unitCost;
        this.stockQty = stockQty;
    }

    public Part(Long partId, String name, String description, BigDecimal unitCost, Integer stockQty, Set<RepairJobPart> repairJobParts) {
        this.partId = partId;
        this.name = name;
        this.description = description;
        this.unitCost = unitCost;
        this.stockQty = stockQty;
        this.repairJobParts = repairJobParts;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public Set<RepairJobPart> getRepairJobParts() {
        return repairJobParts;
    }

    public void setRepairJobParts(Set<RepairJobPart> repairJobParts) {
        this.repairJobParts = repairJobParts;
    }
}
