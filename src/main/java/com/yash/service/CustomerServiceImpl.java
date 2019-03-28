package com.yash.service;

import com.yash.model.Customer;
import com.yash.repository.HibernateCustomerRepo;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    private HibernateCustomerRepo customerRepo;

    public CustomerServiceImpl() {
    }

    public CustomerServiceImpl(HibernateCustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public void setCustomerRepo(HibernateCustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
