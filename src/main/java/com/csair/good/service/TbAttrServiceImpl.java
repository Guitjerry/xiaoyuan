package com.csair.good.service;

import com.csair.good.entity.TbAttr;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Service(value = "tbAttrService")
public class TbAttrServiceImpl implements TbAttrService{
    @PersistenceContext(unitName="localPU")
    @Qualifier(value = "entityManagerFactory")
    protected EntityManager em;
    public List<TbAttr> findAllByCategorycode(String code){
        StringBuffer hql =  new StringBuffer(" select * from  tb_attr where 1=1  ");
        Query query =null;
        if(!StringUtils.isEmpty(code)){
            hql.append(" and categorycode =?1 ");
            query = em.createNativeQuery(hql.toString(),TbAttr.class);
            query.setParameter(1,code);
        }else{
            hql.append(" and categorycode  is null");
            query = em.createNativeQuery(hql.toString(),TbAttr.class);

        }

        List<TbAttr> tbAttrs =query.getResultList();
        return tbAttrs;
    }
}
