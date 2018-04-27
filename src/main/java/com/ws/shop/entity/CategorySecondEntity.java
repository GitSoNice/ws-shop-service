package com.ws.shop.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 二级分类的实体
 */
@Table(name = "categorysecond",catalog = "")
@Entity
public class CategorySecondEntity implements Serializable{

    /**
     * 二级目录id
     */
    private Integer csid;

    /**
     * 二级目录名称
     */
    private String csname;

    /**
     * 一级分类
     */
    private CategoryEntity category;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "CSID",nullable = false)
    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    @Column(name="CSNAME",nullable = true)
    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname;
    }

    @JoinColumn(name = "CID")
    @ManyToOne
    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

}
