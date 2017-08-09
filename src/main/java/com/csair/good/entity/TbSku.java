package com.csair.good.entity;

import javax.persistence.*;

/**
 * SKU表(库存表):
 (SKU编号, 商品编号, SKU属性, 价格, 库存, SKU销量)
 (1, 1, [1:1,2:3], 99, 400, 0) 其中 [1:1,2:3] 表示 "颜色为黑色,尺码为X"
 (2, 1, [1:1,2:4], 99, 200, 0) 其中 [1:1,2:4] 表示 "颜色为黑色,尺码为XL"
 (3, 1, [1:2,2:3], 99, 300, 0) 其中 [1:2,2:3] 表示 "颜色为白色,尺码为X"
 (4, 1, [1:2,2:4], 99, 100, 0) 其中 [1:2,2:4] 表示 "颜色为白色,尺码为X
 */
@Table
@Entity(name = "tb_sku")
public class TbSku {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // MYSQL时可以这样使用自增
    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
    private Integer id;
    private String skucode;//sku编号
    private String goodcode;//商品编号,关联商品code
    private String skuattr;//sku属性
    private String price;
    private int stock;//库存
    private int slaestotal;//销量

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSkucode() {
        return skucode;
    }

    public void setSkucode(String skucode) {
        this.skucode = skucode;
    }

    public String getGoodcode() {
        return goodcode;
    }

    public void setGoodcode(String goodcode) {
        this.goodcode = goodcode;
    }

    public String getSkuattr() {
        return skuattr;
    }

    public void setSkuattr(String skuattr) {
        this.skuattr = skuattr;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSlaestotal() {
        return slaestotal;
    }

    public void setSlaestotal(int slaestotal) {
        this.slaestotal = slaestotal;
    }
}
