package com.csair.good.entity;

import javax.persistence.*;

/**
 * 属性值:
 (属性值编号, 属性值, 属性名编号)
 (1, 黑色, 1)
 (2, 白色, 1)
 (3, X,  2)
 (4, XL, 2)
 (5, 七匹狼, 3)
 (6, 九牧王, 3)
 */
@Table
@Entity(name = "tb_attr_option")
public class TbAttrOption {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    @Column(name="attroptionid")
    private String attroptionid;//属性值编号
    @Column(name="value")
    private String value;//属性值
    @Column(name="attroptioncode")
    private String attroptioncode;//属性名编号

    public String getAttroptionid() {
        return attroptionid;
    }

    public void setAttroptionid(String attroptionid) {
        this.attroptionid = attroptionid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttroptioncode() {
        return attroptioncode;
    }

    public void setAttroptioncode(String attroptioncode) {
        this.attroptioncode = attroptioncode;
    }


}
