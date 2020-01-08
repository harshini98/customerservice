package com.deloitte.telcom.dao;

import com.deloitte.telcom.entities.CustomerService;
import com.deloitte.telcom.exceptions.CustomerNotFoundException;

import java.util.Map;
import java.util.Set;

public interface ICustomerServiceDao {

    void addAccount(CustomerService cs);

    double balanceEnquiry(String mobileno);

    CustomerService addAmount(String mobileno, double amount);

    CustomerService customerDetails(String mobileno);

    Map<String, CustomerService> getStore();

    public boolean credentialsCorrect(String mobileno ,String name);

}
