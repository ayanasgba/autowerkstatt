package com.example.autowerkstatt.autowerkstatt.repository;

import com.example.autowerkstatt.autowerkstatt.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByName(String name);
}
