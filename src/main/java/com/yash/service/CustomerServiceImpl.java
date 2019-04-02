package com.yash.service;

import com.yash.model.Customer;
import com.yash.repository.HibernateCustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl (){}

    @Autowired
    public void setCustomerRepo(HibernateCustomerRepo customerRepo) {
        System.out.println("Setter Inject in Java Conf");
        this.customerRepo = customerRepo;
    }

    private HibernateCustomerRepo customerRepo;

    public  CustomerServiceImpl(HibernateCustomerRepo customerRepo) {
        System.out.println("Constructor Inject in Java Conf");
        this.customerRepo = customerRepo;
    }

    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
