package com.ws.shop.repository;

import com.ws.shop.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 一级分类dao
 * @Author lqh
 * @Date 2018年4月2日 21:25:48
 */
public interface CategoryEntityRepo extends JpaRepository<CategoryEntity,Long> {

    /**
     * 查看所有数据的数量
     * @return
     */
    @Query(nativeQuery = true,value = "select count(*) from category")
    public int countAll();

    /**
     * 通过cid查找
     * @param cid
     * @return
     */
    public CategoryEntity findByCid(Integer cid);

    /**
     * 分页查找所有一级分类
     * @param spec
     * @param pageable
     * @return
     */
    public Page<CategoryEntity> findAll(Specification<CategoryEntity> spec, Pageable pageable);


}
