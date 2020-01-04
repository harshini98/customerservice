package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.ICustomerServiceDao;
import com.deloitte.telcom.entities.CustomerService;
import com.deloitte.telcom.exceptions.IncorrectNumberException;

public class CustomerServiceImpl implements ICustomerService {
    private ICustomerServiceDao dao;

    public CustomerServiceImpl(ICustomerServiceDao dao) {
        this.dao = dao;
    }

    public ICustomerServiceDao getCustomerDao() {
        return dao;
    }

    @Override
    public void addAccount(CustomerService c) {
        dao.addAccount(c);
    }

    @Override
    public double balanceEnquiry(String mobileno) {
        if (mobileno == null || mobileno.length() != 10) {
            throw new IncorrectNumberException("Mobile number enetered is not correct");
        }
        double balance = dao.balanceEnquiry(mobileno);
        return balance;
    }

    @Override
    public CustomerService addAmount(String mobileno, double amount) {
        if (mobileno == null || mobileno.length() != 10) {
            throw new IncorrectNumberException("Mobile number enetered is not correct");
        }
        CustomerService c = dao.addAmount(mobileno, amount);
        return c;
    }

    @Override
    public CustomerService customerDetails(String mobileno) {
        if (mobileno == null || mobileno.length() != 10) {
            throw new IncorrectNumberException("Mobile number enetered is not correct");
        }
        CustomerService c = dao.customerDetails(mobileno);
        return c;
    }
}
