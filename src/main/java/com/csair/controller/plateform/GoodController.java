package com.csair.controller.plateform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/pc/good/*")
public class GoodController {
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
