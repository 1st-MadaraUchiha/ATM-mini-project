package com.atm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.security.auth.login.AppConfigurationEntry;


public class Test {
    private double bb;
     Test(double bb,long acc,int pin) {
        Configuration con = new Configuration().configure("hibernate.xml");
        SessionFactory sf =con.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
         Data_Entry ded = new Data_Entry();
         ded.setAccount_number(acc);
         ded.setPin(pin);
        ded.setBalance(bb);
        sess.update(ded);
        tx.commit();
        sess.close();
        System.out.println("Balance updated...");
    }
    private Test(){
        super();
    }

    public static void main(String[] args) {
//        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
//        Data_Entry insert =(Data_Entry) context.getBean("insert");
//        System.out.println(insert);
        Data_Entry de = new Data_Entry();
        de.setAccount_number(987654321);
        de.setPin(3461);
        de.setBalance(285445.45);
        Configuration con = new Configuration().configure("hibernate.xml");
       SessionFactory sf =con.buildSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        sess.save(de);
        tx.commit();
        sess.close();

    }
}
