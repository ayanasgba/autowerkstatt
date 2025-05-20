package com.example.autowerkstatt.autowerkstatt.services;

import com.example.autowerkstatt.autowerkstatt.model.Part;

import java.util.List;
import java.util.Optional;

public interface PartService {
    List<Part> findAll();
    Optional<Part> findById(int id);
    void save(Part part);
    void delete(int id);
    void update(int id, Part part);
}
