package com.csair.good.repository;

import com.csair.good.entity.TbAttr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbAttrRepository extends JpaRepository<TbAttr,Integer>{
    //根据属性编码查询
    public List<TbAttr> findAllByAttrcode(String code);
    public List<TbAttr> findAllByCategorycode(String categorycode);
}
