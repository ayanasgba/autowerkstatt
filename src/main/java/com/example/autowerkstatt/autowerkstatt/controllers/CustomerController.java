package com.example.autowerkstatt.autowerkstatt.controllers;

import com.example.autowerkstatt.autowerkstatt.model.Customer;
import com.example.autowerkstatt.autowerkstatt.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<Customer> getCustomerService() {
        return customerService.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.findById(id).orElse(null);
    }

    @PostMapping("/customer/save")
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
    }

    @PostMapping("/customer/delete/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.delete(id);
    }

    @PutMapping("/customer/update/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customerService.update(id, customer);
    }
}
