package com.giannopoulos.spring5.rest.template.services;

import com.giannopoulos.spring5.rest.template.domain.Customer;

import java.util.List;

public interface CustomerService {

    Customer findCustomerById(Long id);
    List<Customer> findAllCustomers();
    Customer saveCustomer(Customer customer);
}
