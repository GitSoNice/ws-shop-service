package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.CategorySecondEntity;
import com.ws.shop.utils.ActionResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategorySecondEntityService {

    /**
     * 查找所有二级分类
     * @return
     */
    public List<CategorySecondEntity> findAllCategorySecond();

    /**
     * 通过csid查找二级分类
     * @param csid
     * @return
     */
    public CategorySecondEntity findCategorySecond(Integer csid);

    /**
     * 更新二级分类
     * @param categorySecond
     */
    public ActionResult updateCategorySecond(CategorySecondEntity categorySecond);

    /**
     * 分页查找二级分类
     * @param pageInfo
     * @return
     */
    public Page<CategorySecondEntity> SearchCategorySeconds(PageInfo pageInfo);

    /**
     * 添加二级分类
     * @param categorySecond
     */
    public ActionResult addCategorySecond(CategorySecondEntity categorySecond);

    /**
     * 删除二级分类
     * @param categorySecond
     * @return
     */
    public ActionResult deleteCategorySecond(CategorySecondEntity categorySecond,Integer uid);

}
