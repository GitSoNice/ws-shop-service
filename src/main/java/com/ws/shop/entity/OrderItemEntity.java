package com.ws.shop.entity;

import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

/**
 * 订单项的实体
 */
@Table(name = "orderitem")
@Entity
public class OrderItemEntity {

    private Integer itemid;

    /**
     *数量
     */
    private Integer count;

    /**
     *总金额
     */
    private Float subtotal;

    /**
     * 商品
     */
    private ProductsEntity product;

    /**
     * 订单
     */
    private OrdersEntity orders;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ITEMID",nullable = false)
    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    @Column(name = "COUNT",nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Column(name = "SUBTOTAL",nullable = true)
    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    @ManyToOne
    @JoinColumn(name = "pid")
    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "oid")
    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderItem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + ", product=" + product
                +  "]";
    }
}
