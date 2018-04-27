package com.ws.shop.entity;

import javax.persistence.*;

/**
 *
 * 用户卡包的实体对象
 */

@Table(name = "packet",catalog = "")
@Entity
public class PacketEntity {

    private Integer pacid;
    private Integer uid;


    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="PACID",nullable = false)
    public Integer getPacid() {
        return pacid;
    }

    public void setPacid(Integer pacid) {
        this.pacid = pacid;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "pacid=" + pacid +
                '}';
    }

    @Column(name = "UID",nullable = false)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
