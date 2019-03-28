package com.yash.service;

import com.yash.model.Customer;
import com.yash.repository.HibernateCustomerRepo;
import com.yash.repository.HibernateCustomerRepoImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private HibernateCustomerRepo repo = new HibernateCustomerRepoImpl();

    public List<Customer> findAll() {
        return repo.findAll();
    }
}
