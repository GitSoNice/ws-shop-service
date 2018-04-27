package com.ws.shop.bean;

import java.io.Serializable;

/**
 * 分页公共bean
 */
public class PageInfo implements Serializable{

    /**
     * 页码
     */
    private int page = 0;

    /**
     * 每页的数量
     */
    private int size = 10;

    /**
     * 字段排序
     */
    private String sortName ;



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

}

