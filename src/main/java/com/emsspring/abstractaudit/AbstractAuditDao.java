package com.emsspring.abstractaudit;

import com.emsspring.model.AbstractModel;
import com.emsspring.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;

public abstract class AbstractAuditDao<T extends AbstractModel>{

    @Autowired
    private SessionFactory sessionFactory;

    Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    CriteriaBuilder getCriteriaBuilder(){
        return getSession().getCriteriaBuilder();
    }

    public void save(Object entity){
        getSession().save(entity);
    }

    public int delete(T model){
        CriteriaBuilder cb =  getCriteriaBuilder();
        //CriteriaDelete<T> delete = cb.createCriteriaDelete(model.getClass());
        return 0;
    }

}
