package com.example.Customerms.Service;

import com.example.Customerms.Entity.Customer;

public interface CustomerService {
    Customer signup(Customer customer);

    Customer updateCustomerDetails(Integer customerID, Customer customer);

    Customer deleteCustomer(Integer customerID, Customer customer);

    Customer login(Customer customer);
}
