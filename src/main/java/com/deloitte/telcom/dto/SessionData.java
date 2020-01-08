package com.deloitte.telcom.dto;

import com.deloitte.telcom.entities.CustomerService;

public class SessionData {
    private CustomerService cs;

    public void setCustomer(CustomerService cs){
        this.cs=cs;
    }

    public CustomerService getCustomer(){
        return cs;
    }
}
