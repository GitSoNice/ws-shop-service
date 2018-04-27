package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.CategoryEntity;
import com.ws.shop.utils.ActionResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryEntityService {

    /**
     * 查看所有category分页
     * @param pageInfo
     * @return
     */
    public Page<CategoryEntity> SearchCategorys(PageInfo pageInfo);

    /**
     * 根据cid查询一级分类
     * @param cid
     * @return
     */
    public CategoryEntity findCategory(Integer cid);


    /**
     * 更新一级分类
     * @param category
     */
    public ActionResult updateCategory(CategoryEntity category);

    /**
     * 删除一级分类
     * @param categoryEntity
     * @param uid
     */
    public ActionResult deleteCategory(CategoryEntity categoryEntity, Integer uid);

    /**
     * 保存一级分类
     * @param categoryEntity
     * @return
     */
    public ActionResult addCategory(CategoryEntity categoryEntity);

    /**
     * 查找所有一级分类
     * @return
     */
    public List<CategoryEntity> findCatagorys();
}
