package com.example.autowerkstatt.autowerkstatt.services;

import com.example.autowerkstatt.autowerkstatt.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Optional<Customer> findById(int id);
    void save(Customer customer);
    void delete(int id);
    void update(int id, Customer customer);
}
