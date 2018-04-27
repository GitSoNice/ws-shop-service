package com.ws.shop.entity;

import javax.persistence.*;

/**
 * LQH
 * 2018年3月27日 22:24:29
 * 管理员实体类
 */
@Table(name = "adminuser",catalog = "")
@Entity
public class AdminEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer uid;
    private String username;
    private String password;

    @Column(name = "UID",nullable = false)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name = "USERNAME",nullable = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD",nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
