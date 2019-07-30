package com.emsspring.abstractaudit;

import com.emsspring.model.AbstractModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T>{

    private T instance;

    public AbstractDao(Class<T> inst){
        try {
            instance = inst.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
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

    public void delete(String id){
        CriteriaBuilder cb =  getCriteriaBuilder();
        CriteriaDelete delete = cb.createCriteriaDelete(instance.getClass());
        Root root = delete.from(instance.getClass());
        delete.where(cb.equal(root.get("id"),id));
        getSession().createQuery(delete).executeUpdate();
    }

   // public List<T> list(T model){}

}
