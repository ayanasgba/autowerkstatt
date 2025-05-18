package com.example.autowerkstatt.autowerkstatt.services.Impl;

import com.example.autowerkstatt.autowerkstatt.model.Customer;
import com.example.autowerkstatt.autowerkstatt.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> findAll() {
        return List.of();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Customer c) {

    }

    @Override
    public void delete(int id) {

    }
}
