package com.ws.shop.entity;


import javax.persistence.*;
import java.util.Date;

/**
 * 商品实体类
 */
@Entity
@Table(name="PRODUCT" , catalog = "")
public class ProductsEntity{

    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 商品名称
     */
    private String pname;

    /**
     *市场价
     */
    private Float market_price;

    /**
     *现价
     */
    private Float shop_price;

    /**
     *库存
     */
    private Integer inventory;

    /**
     *图片
     */
    private String image;

    /**
     *商品描述
     */
    private String pdesc;

    /**
     *是否热门
     */
    private Integer is_hot;

    /**
     *时间
     */
    private Date pdate;

    /**
     * 二级目录
     * @return
     */

    private CategorySecondEntity categorySecond;

    /**
     * 一级目录
     */
    private Integer cid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "PID", nullable = false, precision = 0)
    public Integer getPid(){
        return pid;
    }

    public void setPid(Integer pid){
        this.pid=pid;
    }

    @Column(name= "PNAME" ,nullable = true,length = 255)
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Column(name= "MARKET_PRICE",nullable = true)
    public Float getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Float market_price) {
        this.market_price = market_price;
    }

    @Column(name= "SHOP_PRICE",nullable = true)
    public Float getShop_price() {
        return shop_price;
    }

    public void setShop_price(Float shop_price) {
        this.shop_price = shop_price;
    }

    @Column(name= "INVENTORY",nullable = false)
    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    @Column(name= "IMAGE",nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name= "PDESC",nullable = false)
    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    @Column(name= "IS_HOT",nullable = false)
    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    @Column(name= "PDATE",nullable = false)
    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @JoinColumn(name = "csid")
    @ManyToOne
    public CategorySecondEntity getCategorySecond() {
        return categorySecond;
    }

    public void setCategorySecond(CategorySecondEntity categorySecond) {
        this.categorySecond = categorySecond;
    }

    @Column(name= "CID",nullable = true)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "ProductsEntity{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", market_price=" + market_price +
                ", shop_price=" + shop_price +
                ", inventory=" + inventory +
                ", image='" + image + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", is_hot=" + is_hot +
                ", pdate=" + pdate +
                ", categorySecond=" + categorySecond +
                ", cid=" + cid +
                '}';
    }
}
