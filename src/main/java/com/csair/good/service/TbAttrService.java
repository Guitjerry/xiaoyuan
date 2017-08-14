package com.csair.good.service;

import com.csair.good.entity.TbAttr;

import java.util.List;

public interface TbAttrService {
    public List<TbAttr> findAllByCategorycode(String code);
}
