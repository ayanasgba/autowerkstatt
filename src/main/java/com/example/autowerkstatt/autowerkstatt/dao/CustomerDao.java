package com.example.autowerkstatt.autowerkstatt.dao;

import com.example.autowerkstatt.autowerkstatt.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> findAll();
    Optional<Customer> findById(int id);
    int save(Customer customer);
    int update(Customer customer);
    int deleteById(int id);
}