package com.deloitte.telcom.dao;

import com.deloitte.telcom.exceptions.*;
import com.deloitte.telcom.entities.CustomerService;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class CustomerServiceDaoImpl implements ICustomerServiceDao {
    Map<String, CustomerService> store = new HashMap<>();

    public Map<String, CustomerService> getStore(){
        return store;
    }
    @Override
    public void addAccount(CustomerService cs) {
        if(cs.getMobileno()==null || cs.getMobileno().length()!=10){
            throw new IncorrectNumberException("correct mobile number not entered.");
        }
        store.put(cs.getMobileno(), cs);
    }

    @Override
    public double balanceEnquiry(String mobileno) {
        CustomerService c = store.get(mobileno);
        if (c == null) {
            throw new CustomerNotFoundException("Customer is not registered:" + mobileno);
        }
        return c.getBalance();
    }

    @Override
    public CustomerService addAmount(String mobileno, double amount) {
        CustomerService c = store.get(mobileno);
        if (c == null) {
            throw new CustomerNotFoundException("Customer is not registered:" + mobileno);
        }
        double balance = c.getBalance();
        balance = balance + amount;
        c.setBalance(balance);
        return c;
    }

    @Override
    public CustomerService customerDetails(String mobileno){

        CustomerService c=store.get(mobileno);
        if(c==null){
            throw new CustomerNotFoundException("Mobile no is not registered");
        }
        return c;
    }

    @Override
    public boolean credentialsCorrect(String mobileno ,String name){
        CustomerService cs=store.get(mobileno);
        if(cs==null){
            return false;
        }
        return cs.getName().equals(name);
    }
}
