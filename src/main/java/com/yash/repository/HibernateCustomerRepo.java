package com.yash.repository;

import com.yash.model.Customer;

import java.util.List;

public interface HibernateCustomerRepo {
    List<Customer> findAll();
}
