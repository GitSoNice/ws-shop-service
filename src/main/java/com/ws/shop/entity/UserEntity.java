package com.ws.shop.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * LQH
 * 2018年3月27日 22:23:47
 * 用户实体类
 */
@Table(name = "user",catalog = "")
@Entity
public class UserEntity {

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 用户名
     */
    @NotEmpty(message="用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message="密码不能为空")
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮件
     */
    @NotEmpty(message="邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    /**
     * 电话
     */
    @Size(min = 8,max = 11,message ="电话位数需要在8-11位之间")
    private String phone;

    /**
     * 年龄
     */
    @Min(value=13, message="年龄不能小于13岁")
    private Integer age;

    /**
     * 地址
     */
    @NotEmpty
    private String addr;

    /**
     *状态
     */
    private Integer state;

    /**
     *验证码
     */
    private String code;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "UID",nullable=false)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Column(name= "USERNAME",nullable = true)
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

    @Column(name = "NAME",nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="EMAIL",nullable = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "PHONE",nullable = true)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "AGE",nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name="ADDR",nullable = true)
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Column(name = "STATE",nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Column(name = "CODE",nullable = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}
