package com.atm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Data_Entry {
    @Id
    private long account_number;
    private int pin;
    private double balance;

    public Data_Entry() {

        super();
    }

    public Data_Entry(long account_number, int pin,double balance) {
        this.account_number = account_number;
        this.pin = pin;
    }

    public long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(long account_number) {
        this.account_number = account_number;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    public double getBalance(){return balance;}
    public void setBalance(double balance){
        this.balance=balance;
    }
}
