package com.ws.shop.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单实体类
 */
@Table(name = "orders",catalog = "")
@Entity
public class OrdersEntity {

    private Integer oid;
    /**
     *总金额
     */
    private Float total;
    /**
     * 下单时间
     */
    private Date ordertime;
    /**
     * 订单状态  1:未付款   2:订单已经付款   3:已经发货   4:订单结束
     */
    private Integer state;
    /**
     * 收件人
     */
    private String name;
    /**
     * 电话
     */
    private String phone;
    /**
     * 地址
     */
    private String addr;
    /**
     * 用户
     */
    private UserEntity user;

    private Set<OrderItemEntity> orderItems = new HashSet<OrderItemEntity>();

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "OID",nullable = false)
    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }


    @Column(name = "TOTAL",nullable =true )
    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Column(name = "ORDERTIME",nullable = true)
    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @Column(name = "STATE",nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name = "NAME",nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PHONE",nullable = true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "ADDR",nullable = true)
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @JoinColumn(name = "uid")
    @ManyToOne
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER ,mappedBy = "orders")
    public Set<OrderItemEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItemEntity> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", name="
                + name + ", phone=" + phone + ", addr=" + addr + ", user=" + user + ", orderItems=" + orderItems + "]";
    }
}
