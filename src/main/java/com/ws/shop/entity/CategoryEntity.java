package com.ws.shop.entity;

import org.springframework.format.annotation.DateTimeFormat;
import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 一级分类实体类
 */
@Table(name = "category",catalog = "")
@Entity
public class CategoryEntity implements Serializable{

    /**
     * 一级目录id
     */
    private Integer cid;

    /**
     * 一级目录名字
     */
    private String cname;

    /**
     * 折扣
     */
    private Float discount;

    /**
     * 优惠时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date privilegeTime;

    /**
     * 二级分类集合
     */
    private Set<CategorySecondEntity> categorySeconds = new HashSet<CategorySecondEntity>();

    /**
     *优惠
     */
    private TicketEntity ticket;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "CID",nullable = false)
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Column(name="CNAME",nullable = true)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Column(name="DISCOUNT",nullable = true)
    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    @Column(name = "PRIVILEGETIME",nullable = true)
    public Date getPrivilegeTime() {
        return privilegeTime;
    }

    public void setPrivilegeTime(Date privilegeTime) {
        this.privilegeTime = privilegeTime;
    }

    @OrderBy(value = "csid")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    public Set<CategorySecondEntity> getCategorySeconds() {
        return categorySeconds;
    }

    public void setCategorySeconds(Set<CategorySecondEntity> categorySeconds) {
        this.categorySeconds = categorySeconds;
    }

    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "category")
    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }
}