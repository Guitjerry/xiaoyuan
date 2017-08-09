package com.csair.good.entity;

import javax.persistence.*;

/**
 * 属性名:
 (属性名编号, 属性名, 商品分类编号, 父属性编号)
 (1, 颜色, 2, 0)
 (2, 尺码, 2, 0)
 (3, 品牌, 2, 0)
 上面只列出裤子这个分类的3个属性名.
 */
@Table
@Entity(name = "tb_attr")
public class TbAttr {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    private Integer id;
    private String name;//属性名
    private String code;//属性名编号
    private String categorycode;//商品分类编号
    private String parentcode;// 父属性编号

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(String categorycode) {
        this.categorycode = categorycode;
    }

    public String getParentcode() {
        return parentcode;
    }

    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
