package com.yash.repository;

import com.yash.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class HibernateCustomerRepoImpl implements HibernateCustomerRepo {

    public List<Customer> findAll() {
        List<Customer> customers = new ArrayList();
        Customer customer = new Customer() {
            {
                setFirstName("Yash");
                setLastName("Bhardwaj");
            }
        };
        customers.add(customer);
        return customers;
    }
}