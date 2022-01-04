package com.atm;

import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

class Options extends Factory {
    private long account_number;
    private int pin;
public Options(){

}
    public Options(long account_number,int pin) {
        this.account_number =account_number;
        this.pin=pin;
        System.out.println("Welcome to ATM");
        System.out.println("Please select the options below");
        System.out.println("Press 1 to check balance");
        System.out.println("Press 2 to deposit money");
        System.out.println("Press 3 to withdraw money");
        System.out.println("Press 4 to exit");
        Scanner sc2 = new Scanner(System.in);
        int a = sc2.nextInt();
        switch (a) {
            case 1 : checkBalance();
                break;
            case 2 :depositMoney();
                break;
            case 3 : withdrawMoney();
                break;
            case 4 :exit();
                break;
            default : {
                System.out.println("Invalid Input");
                new Options(this.account_number,this.pin);
                break;
            }
        }

//        return this.account_number;

    }

    private void checkBalance(){
        Query q1 = sess.createQuery("select balance from Data_Entry where account_number='"+this.account_number+"'");
        List list= q1.list() ;
        System.out.println("Checking balance....");
        System.out.println("your balance is: Rs."+list);
       extra();
        }

    private void depositMoney(){
        Query q2 = sess.createQuery("select balance from Data_Entry where account_number='"+this.account_number+"'");
        List list = q2.list();
        System.out.println("How much money do you want to deposit?");
        Scanner sc4=new Scanner(System.in);
        double b = sc4.nextDouble();
        Object[] objects = list.toArray();
        double a = (double) objects[0];
        double sum=a+b;
        Test test = new Test(sum,account_number,this.pin);
        extra();

    }
    private void withdrawMoney(){
    Query q3 = sess.createQuery("select balance from Data_Entry where account_number='"+this.account_number+"'");
    List list1 = q3.list();
        System.out.println("How much money do you want to withdraw?");
        Scanner sc5 = new Scanner(System.in);
        double wd=sc5.nextDouble() ;
        Object[] obj2 = list1.toArray();
        double bb=(Double)obj2[0];
        Double diff=bb-wd;
        if (diff<=0){
            System.out.println("You don't have enough balance. Re-enter the balance after confirming");
            System.out.println("Press any Enter Key to continue");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();
             new Options(this.account_number,this.pin);
        }
        else {

            Test test = new Test(diff,account_number,this.pin);
            extra();
        }
    }
    public void exit(){
        System.out.println("Thanks for visiting. You can exit now");

    }
    void extra(){
        sess.close();
        sf.close();
        System.out.println("Do you want to go to options menu? y/n");
        Scanner sc4 = new Scanner(System.in);
        String s =sc4.next();
        if((s.equals("y")) || (s.equals("Y"))) {
            new Options(this.account_number,this.pin);
        }
        else {
            exit();
        }
    }
}
