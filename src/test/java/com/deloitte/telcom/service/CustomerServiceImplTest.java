package com.deloitte.telcom.service;

import com.deloitte.telcom.dao.CustomerServiceDaoImpl;
import com.deloitte.telcom.entities.CustomerService;
import com.deloitte.telcom.service.CustomerServiceImpl;

import org.junit.*;

import java.util.Map;

public class CustomerServiceImplTest {

    @Test
    public void testCreateAccount_1(){
        CustomerServiceImpl service=new CustomerServiceImpl(new CustomerServiceDaoImpl());
        String mobileno="8999898988";
        double balance=1000;
        String name="ashdasuj";
        String type="postpaid";
        CustomerService c1=new CustomerService(mobileno,name,type);
        c1.setBalance(balance);
        service.addAccount(c1);
        Assert.assertNotNull(c1);
        double resultBalance=c1.getBalance();
        Assert.assertEquals(balance, resultBalance,0);
        Assert.assertEquals(name, c1.getName());
        Map<String,CustomerService> store=service.getCustomerDao().getStore();
        CustomerService expected=store.get(mobileno);
        Assert.assertNotNull(expected);
        Assert.assertEquals(expected,c1);
    }
}
