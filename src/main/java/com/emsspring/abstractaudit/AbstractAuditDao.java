package com.emsspring.abstractaudit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractAuditDao {

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public void save(Object entity){
        getSession().save(entity);
    }

}
