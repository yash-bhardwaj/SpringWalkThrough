package com.yash.service;

import com.yash.model.Customer;
import com.yash.repository.HibernateCustomerRepo;
import com.yash.repository.HibernateCustomerRepoImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private HibernateCustomerRepo customerRepo;

    public void setCustomerRepo(HibernateCustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
