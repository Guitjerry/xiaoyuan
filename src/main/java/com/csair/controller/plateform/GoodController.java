package com.csair.controller.plateform;

import com.csair.good.entity.TbAttr;
import com.csair.good.repository.TbAttrRepository;
import com.csair.good.service.TbAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/pc/good/*")
public class GoodController {
    @Autowired
    TbAttrRepository tbAttrRepository;
    @Autowired
    TbAttrService tbAttrService;
    /**
     * 列表
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "list")
    public String list(HttpServletRequest request, HttpServletResponse response){
        return "pc/good/list";
    }

    /**
     * 添加商品
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addGood")
    public String addGood(HttpServletRequest request, HttpServletResponse response){
        List<TbAttr> tbAttrList = tbAttrService.findAllByCategorycode(null);
        List<TbAttr> tbAttrListCa = tbAttrService.findAllByCategorycode("mala");
        request.setAttribute("msg","good");
        request.setAttribute("tbAttrList",tbAttrList);//公用属性
        request.setAttribute("tbAttrListCa",tbAttrListCa);//某类属性
        return "pc/good/addGood";
    }

    /**
     * 编辑商品
     * @param request
     * @param response
     */
    @RequestMapping(value = "ajax_good_edit")
    public void ajax_good_edit(HttpServletRequest request, HttpServletResponse response){

    }
}
