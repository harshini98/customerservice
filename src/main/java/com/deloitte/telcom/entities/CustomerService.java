package com.deloitte.telcom.entities;

public class CustomerService {
    private String mobileno;
    private String name;
    private String accountType;
    private double balance;

    public CustomerService(String mobileno, String name, String accountType) {
        this.mobileno = mobileno;
        this.name = name;
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }

    public String getMobileno() {
        return mobileno;
    }



    @Override
    public String toString() {
        return mobileno + " | " + name + " | " + accountType + " | " + balance;
    }
}
