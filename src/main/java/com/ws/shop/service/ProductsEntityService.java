package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.ProductsEntity;
import com.ws.shop.entity.UserEntity;
import com.ws.shop.utils.ActionResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductsEntityService {

    /**
     * 根据二级分类查找商品
     * @param csid
     * @param pageInfo
     * @return
     */
    public Page<ProductsEntity> findByCsid(final Integer csid, PageInfo pageInfo) ;

    /**
     * 根据名字查找商品
     * @param name
     * @param pageInfo
     * @return
     */
    public Page<ProductsEntity> findByName(final String name, PageInfo pageInfo) ;

    /**
     * 根据一级分类查询商品
     * @param cid
     * @param pageInfo
     * @return
     */
    public Page<ProductsEntity> findByCid(final Integer cid, PageInfo pageInfo);

    /**
     *  查找最热的商品10条
     * @param hot
     * @return
     */
    public List<ProductsEntity> findHot(String hot);

    /**
     * 查找最新的商品10条
     * @return
     */
    public List<ProductsEntity> findNew();

    /**
     * 根据商品的pid的值查询商品
     * @param pid
     * @return
     */
    public ProductsEntity findByPid(Integer pid);

    /**
     * 一级分类有多少的数据
     * @param cid
     * @return
     */
    public Integer CountPageProductFromCategory(Integer cid);

    /**
     * 二级分类有多少的数据
     * @param csid
     * @return
     */
    public Integer CountPageProductFromCategorySecond(Integer csid);

    /**
     * 更新商品的信息
     * @param product
     */
    public ActionResult updateProduct(ProductsEntity product);

    /**
     * 保存商品信息
     * @param prodcut
     */
    public ActionResult saveProduct(ProductsEntity prodcut);

    /**
     * 删除商品
     * @param prodcut
     * @return
     */
    public ActionResult deleteProduct(ProductsEntity prodcut,Integer uid);

    /**
     * 分页查找所有商品
     * @param pageInfo
     * @return
     */
    public Page<ProductsEntity> SearchProducts(PageInfo pageInfo);

}
