package com.csair.good.entity;

import javax.persistence.*;

/**
 * 商品和属性关系表:
 (自增编号, 商品编号, 属性名编号, 属性值编号)
 (1, 1, 1, 1) 商品1颜色为黑色
 (2, 1, 1, 2) 商品1颜色为白色
 (3, 1, 2, 3) 商品1尺码为X
 (4, 1, 2, 4) 商品1尺码为XL
 */
@Table
@Entity(name = "tb_good_and_attr")
public class TbGoodAndAttr {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    private Integer id;
    @Column(name="goodcode")
    private String goodcode;//商品编号
    @Column(name="attrcode")
    private String attrcode;//属性名编号
    @Column(name="attrvalue")
    private String attrvalue;//属性值编号

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodcode() {
        return goodcode;
    }

    public void setGoodcode(String goodcode) {
        this.goodcode = goodcode;
    }

    public String getAttrcode() {
        return attrcode;
    }

    public void setAttrcode(String attrcode) {
        this.attrcode = attrcode;
    }

    public String getAttrvalue() {
        return attrvalue;
    }

    public void setAttrvalue(String attrvalue) {
        this.attrvalue = attrvalue;
    }

}
