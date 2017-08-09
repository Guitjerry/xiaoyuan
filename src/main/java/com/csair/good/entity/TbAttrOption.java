package com.csair.good.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

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
    private String attrcode;//属性值编号
    private String value;//属性值
    private String attroptioncode;//属性名编号

    public String getAttrcode() {
        return attrcode;
    }

    public void setAttrcode(String attrcode) {
        this.attrcode = attrcode;
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
