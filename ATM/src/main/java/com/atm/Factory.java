package com.atm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


class Factory {
            Configuration config = new Configuration().configure("hibernate.xml");
            SessionFactory sf = config.buildSessionFactory();
            Session sess = sf.openSession();
            Transaction tx = sess.beginTransaction();


    }
