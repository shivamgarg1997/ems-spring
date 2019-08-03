package com.emsspring.abstractaudit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

public abstract class AbstractDao<T>{

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public CriteriaBuilder getCriteriaBuilder(){
        return getSession().getCriteriaBuilder();
    }

    public void save(Object entity){
        getSession().save(entity);
    }
}
