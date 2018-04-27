package com.ws.shop.bean;

import com.ws.shop.entity.ProductsEntity;

/**
 * 购物项
 */
public class CartItem {

    /**
     * 购物项中商品信息
     */
    private ProductsEntity product;

    /**
     * 价格
     */
    private Float price = 1.0f;
    /**
     * 商品数量
     */
    private int count;
    /**
     * 购买商品小计
     */
    private float subtotal;

    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getSubtotal() {
        return count * getPrice();

    }


}
