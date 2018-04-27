package com.ws.shop.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 优惠券实体类
 */
@Table(name ="ticket",catalog = "")
@Entity
public class TicketEntity {

    /**
     * 优惠券编号
     */
    private Integer tid;

    /**
     * 优惠券金额
     */
    private Float privilege;

    /**
     * 满减金额
     */
    private Float consume;

    /**
     * 使用期限
     */
    private Date useTime;


    private CategoryEntity category;

    private PacketEntity packetEntity;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="TID",nullable = false)
    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Column(name="PRIVILEGE",nullable = false)
    public Float getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Float privilege) {
        this.privilege = privilege;
    }

    @Column(name="CONSUME",nullable = false)
    public Float getConsume() {
        return consume;
    }

    public void setConsume(Float consume) {
        this.consume = consume;
    }

    @Column(name ="USETIME",nullable = false)
    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    @OneToOne
    @JoinColumn(name ="cid")
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @ManyToOne
    @JoinColumn(name = "pacid")
    public PacketEntity getPacketEntity() {
        return packetEntity;
    }

    public void setPacketEntity(PacketEntity packetEntity) {
        this.packetEntity = packetEntity;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "tid=" + tid +
                ", privilege=" + privilege +
                ", consume=" + consume +
                ", useTime=" + useTime +
                ", category=" + category +
                '}';
    }
}
