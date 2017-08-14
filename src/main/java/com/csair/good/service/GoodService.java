package com.csair.good.service;

import com.csair.good.entity.TbAttr;

import java.util.List;

public interface GoodService {
    public List<TbAttr> findAllBycategorycode(String categorycode);
}
