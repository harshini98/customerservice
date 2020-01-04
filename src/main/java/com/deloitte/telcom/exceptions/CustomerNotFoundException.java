package com.deloitte.telcom.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
