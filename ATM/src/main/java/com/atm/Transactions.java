package com.atm;

import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transactions extends Factory {
    private long account_number;
    private int pin;
    private ArrayList<Long> omg=new ArrayList<>(1);
    private ArrayList<Integer> n= new ArrayList<>(1);


    Transactions(long account_number, int pin) {
        this.account_number = account_number;
        this.pin = pin;
        omg.add(account_number);
        n.add(pin);
//        System.out.println("...................");
        Query q = sess.createQuery("select account_number from Data_Entry as s where s.account_number='"+this.account_number+"' and s.pin='"+this.pin+"'");
        List entry = q.list();
        Query q1= sess.createQuery("select pin from Data_Entry as m where m.pin='"+this.pin+"' and m.account_number='"+this.account_number+"'");
        List entry2 = q1.list();
//        System.out.println((entry));
//        System.out.println(entry2);
//        Query q1 = sess.createQuery("from Data_Entry as s where s.account_number='"+this.account_number+"'");
//        List li1= q1.list();
//        Query q2 = sess.createQuery("from Data_Entry as s where s.pin='"+this.pin+"'");
//        List li2 = q2.list();
        int i=0;
        { if (entry.equals(omg) && ((entry2.equals(n))))
                {
                    i = 1;
                }
           };
        tx.commit();
        sess.close();
        if (i>0) {
            Options op = new Options(this.account_number,this.pin);
        }
        else {
            System.out.println("Wrong Account number or Pin number");
            System.out.println("Do you want to go to Login Page? y/n");
            Scanner sc3 = new Scanner(System.in);
            String c = sc3.next();
            if((c.equals("y")) || (c.equals("Y"))) {

                Main.main(null);
            }
            else {
                System.out.println("Thanks for visiting. See ya");
            }
            }
    }

}
