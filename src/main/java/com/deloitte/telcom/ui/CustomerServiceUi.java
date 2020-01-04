package com.deloitte.telcom.ui;

import com.deloitte.telcom.entities.CustomerService;
import com.deloitte.telcom.dao.CustomerServiceDaoImpl;
import com.deloitte.telcom.service.CustomerServiceImpl;
import com.deloitte.telcom.service.ICustomerService;


public class CustomerServiceUi {
    private ICustomerService service=new CustomerServiceImpl(new CustomerServiceDaoImpl());
    public static void main(String[] args){
        CustomerServiceUi ui=new CustomerServiceUi();
        ui.execute();
    }
    public void execute() {
        try{
            String mobileno1="6578676687";
            String name1="anamika";
            String type1="postpaid";
            String mobileno2="8976564534";
            String name2="punith";
            String type2="prepaid";
            CustomerService c1=new CustomerService(mobileno1, name1, type1);
            CustomerService c2=new CustomerService(mobileno2,name2,type2);
            c1.setBalance(27678);
            c2.setBalance(4659);
            service.addAccount(c1);
            service.addAccount(c2);
            double balance=service.balanceEnquiry(mobileno1);
            System.out.println("current balance of the customer mobile account is:"+balance);
            CustomerService c=service.addAmount(mobileno2,678.989);
            System.out.println(c);
            CustomerService cd=service.customerDetails(mobileno1);
            System.out.println(cd);
        }
        catch(Throwable e){
            e.printStackTrace();
            System.out.println("Something went wrong");
        }
    }

}
