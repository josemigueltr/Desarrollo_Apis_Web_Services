package com.dws.costumerservice.service;

import java.util.List;

import com.dws.costumerservice.dto.Customer;
import com.dws.costumerservice.dto.RespuestaApi;

public interface CustomerService {

    public List<Customer> getCustomers();
    public Customer getCustomer(int id);
    public RespuestaApi createCustomer(Customer customer);
    public RespuestaApi updateCustomer(Customer customer, int id);
    public RespuestaApi deleteCustomer(int id);
}