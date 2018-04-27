package com.ws.shop.entity;

import javax.persistence.*;

/**
 * 钱包实体类
 */
@Table(name = "wallet",catalog = "")
@Entity
public class WalletEntity {

    private Integer wid;
    /**
     * 余额
     */
    private Float money;
    /**
     * 用户id
     */
    private Integer uid;

    private UserEntity user;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "WID",nullable = false)
    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    @Column(name = "MONEY",nullable = true)
    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @OneToOne(optional = false)
    @JoinColumn(name = "uid", unique = true, nullable = false, updatable = false, insertable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wallet [wid=" + wid + ", money=" + money + "]";
    }
}
