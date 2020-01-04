package com.deloitte.telcom.service;

import com.deloitte.telcom.entities.CustomerService;

public interface ICustomerService {
    void addAccount(CustomerService cs);

    double balanceEnquiry(String mobileno);

    CustomerService addAmount(String mobileno, double amount);

    CustomerService customerDetails(String mobileno);

}
