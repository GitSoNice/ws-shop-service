package com.ws.shop.repository;

import com.ws.shop.entity.CategorySecondEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 二级分类dao
 * @Author lqh
 * @Date 2018年4月2日 21:26:25
 */
public interface CategorySecondEntityRepo extends JpaRepository<CategorySecondEntity,Long> {

    /**
     * 查找所有数据的数量
     * @return
     */
    @Query(nativeQuery = true,value = "select count(*) from categorysecond")
    public int countAll();

    /**
     * 通过id查找
     * @param csid
     * @return
     */
    public CategorySecondEntity findByCsid(Integer csid);

    /**
     * 分页查找所有二级分类
     * @param spec
     * @param pageable
     * @return
     */
    public Page<CategorySecondEntity> findAll(Specification<CategorySecondEntity> spec, Pageable pageable);

}
