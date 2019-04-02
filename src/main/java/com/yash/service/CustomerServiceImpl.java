package com.yash.service;

import com.yash.model.Customer;
import com.yash.repository.HibernateCustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private HibernateCustomerRepo customerRepo;

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
