package com.yash.repository;

import com.yash.model.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("customerRepo")
public class HibernateCustomerRepoImpl implements HibernateCustomerRepo {

    @Value("${dbUsername}")
    private String dbUsername;
    public List<Customer> findAll() {
        System.out.println("S: "+ dbUsername);
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