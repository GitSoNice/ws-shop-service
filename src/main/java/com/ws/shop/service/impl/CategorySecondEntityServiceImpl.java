package com.ws.shop.service.impl;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.AdminEntity;
import com.ws.shop.entity.CategorySecondEntity;
import com.ws.shop.repository.CategorySecondEntityRepo;
import com.ws.shop.service.AdminEntityService;
import com.ws.shop.service.CategorySecondEntityService;
import com.ws.shop.utils.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 二级分类service
 * @Author lqh
 * @Date 2018年4月2日 21:41:20
 */
@Service
public class CategorySecondEntityServiceImpl implements CategorySecondEntityService {

    private Logger logger = LoggerFactory.getLogger(CategorySecondEntityServiceImpl.class);
    @Autowired
    CategorySecondEntityRepo categorySecondEntityRepo;

    @Autowired
    AdminEntityService adminEntityService;
    /**
     * 查找所有二级分类
     * @return
     */
    @Override
    public List<CategorySecondEntity> findAllCategorySecond() {
        return categorySecondEntityRepo.findAll();
    }

    /**
     * 通过csid查找二级分类
     * @param csid
     * @return
     */
    @Override
    public CategorySecondEntity findCategorySecond(Integer csid) {
        if(csid == null){
            return null;
        }
        return categorySecondEntityRepo.findByCsid(csid);
    }

    /**
     * 更新二级分类
     * @param categorySecond
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult updateCategorySecond(CategorySecondEntity categorySecond) {
        if(categorySecond == null){
            return ActionResult.failure("二级分类不存在");
        }
        try {
            logger.info("待更新的二级分类{}",categorySecond);
            categorySecondEntityRepo.save(categorySecond);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("更新categorySecond出错{}",e);
            return ActionResult.failure("更新categorySecond出错");
        }
    }

    /**
     * 分页查找所有二级分类
     * @param pageInfo
     * @return
     */
    @Override
    public Page<CategorySecondEntity> SearchCategorySeconds(PageInfo pageInfo) {
        Specification<CategorySecondEntity> specification = new Specification<CategorySecondEntity>() {

            @Override
            public Predicate toPredicate(Root<CategorySecondEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                criteriaQuery.where(predicate);
                return predicate;
            }
        };
        pageInfo.setSortName("csid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return categorySecondEntityRepo.findAll(specification, pageable);
    }

    /**
     * 插入二级分类
     * @param categorySecond
     * @return
     */
    @Override
    public ActionResult addCategorySecond(CategorySecondEntity categorySecond) {
        if(categorySecond == null){
            return ActionResult.failure("二级分类不存在");
        }
        logger.info("待插入的二级分类{}",categorySecond);
        categorySecondEntityRepo.save(categorySecond);
        return ActionResult.SUCCESS;
    }

    /**
     * 删除二级分类
     * @param categorySecond
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult deleteCategorySecond(CategorySecondEntity categorySecond,Integer uid) {
        AdminEntity admin = adminEntityService.SearchAdmin(uid);
        if(admin == null){
            return ActionResult.failure("没有此权限");
        }
        try {
            logger.info("待删除的二级分类{}",categorySecond);
            categorySecondEntityRepo.delete(categorySecond);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("删除categorySecond出错{}",e);
            return ActionResult.failure("删除categorySecond出错");
        }
    }
}
