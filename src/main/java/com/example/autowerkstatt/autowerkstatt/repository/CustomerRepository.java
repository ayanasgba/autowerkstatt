package com.example.autowerkstatt.autowerkstatt.repository;

import com.example.autowerkstatt.autowerkstatt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    Optional<Customer> findByPhone(String phone);

    Optional<Customer> findByEmail(String email);
}

