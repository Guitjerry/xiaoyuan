package com.csair.good.service;

import com.csair.good.entity.TbAttr;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class GoodServiceImpl implements GoodService{
    @PersistenceContext(unitName="localPU")
    @Qualifier(value = "entityManagerFactory")
    protected EntityManager em;
    public List<TbAttr> findAllBycategorycode(String categorycode) {
        String hql = " from TbAttr where categorycode=?1";
        Query query = em.createQuery(hql).setParameter(1,categorycode);
        return query.getResultList();
    }
    //public
}
