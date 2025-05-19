package com.example.autowerkstatt.autowerkstatt.services.Impl;

import com.example.autowerkstatt.autowerkstatt.dao.Impl.CustomerDaoImpl;
import com.example.autowerkstatt.autowerkstatt.model.Customer;
import com.example.autowerkstatt.autowerkstatt.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDaoImpl customerDao;

    public CustomerServiceImpl(CustomerDaoImpl customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerDao.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void delete(int id) {
        customerDao.deleteById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerDao.update(id, customer);
    }
}
