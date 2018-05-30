package com.ws.shop.repository;

import com.ws.shop.entity.ProductsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 商品dao
 * @Author lqh
 * @Date 2018年4月2日 21:29:28
 */
public interface ProductsEntityRepo extends JpaRepository<ProductsEntity,Long> ,JpaSpecificationExecutor<ProductsEntity> {

    /**
     * 通过cid查找商品
     * @param cid
     * @return
     */
    @Query(nativeQuery = true,value="select count(*) from Product p, Category c, CategorySecond cs where p.categorySecond.csid = cs.csid and cs.category.cid = c.cid and c.cid = ?")
    public Integer CountProductForCategory(Integer cid);

    /**
     * 通过csid查找商品
     * @param csid
     * @return
     */
    @Query(nativeQuery = true,value = "select count(*) from Product p ,CategorySecond cs where p.categorySecond.csid = cs.csid and cs.csid = ?")
    public Integer CountPageProductFromCategorySecond(Integer csid);

    /**
     * 统计数量
     * @return
     */
    @Query(nativeQuery = true,value = "select count(*) from product")
    public int countAll();

    /**
     * 通过pid查找
     * @param pid
     * @return
     */
    public ProductsEntity findByPid(Integer pid);

    /**
     * 查找最新商品
     * @return
     */
    @Query(nativeQuery = true,value = "select * from product order by pdate desc limit 0,10")
    public List<ProductsEntity> findNewProduct();

    @Query(nativeQuery =true ,value="select * from product where is_hot=? order by pid desc limit 0,10")
    public List<ProductsEntity>findByIs_hot(String hot);

}
