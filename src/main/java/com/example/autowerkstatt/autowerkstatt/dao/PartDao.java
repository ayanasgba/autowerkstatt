package com.example.autowerkstatt.autowerkstatt.dao;

import com.example.autowerkstatt.autowerkstatt.model.Part;

import java.util.List;
import java.util.Optional;

public interface PartDao {
    List<Part> findAll();
    Optional<Part> findById(int id);
    int save(Part part);
    int update(int id, Part part);
    int deleteById(int id);
}
