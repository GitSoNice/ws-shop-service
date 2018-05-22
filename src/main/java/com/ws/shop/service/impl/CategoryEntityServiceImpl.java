package com.ws.shop.service.impl;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.AdminEntity;
import com.ws.shop.entity.CategoryEntity;
import com.ws.shop.entity.ProductsEntity;
import com.ws.shop.repository.CategoryEntityRepo;
import com.ws.shop.service.AdminEntityService;
import com.ws.shop.service.CategoryEntityService;
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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * 一级分类service
 * @Author lqh
 * @Date 2018年4月2日 21:35:37
 */
@Service
public class CategoryEntityServiceImpl implements CategoryEntityService {

    private Logger logger = LoggerFactory.getLogger(CategoryEntityServiceImpl.class);

    @Autowired
    CategoryEntityRepo categoryEntityRepo;

    @Autowired
    AdminEntityService adminEntityService;

    /**
     * 分页查找所有一级分类
     * @param pageInfo
     * @return
     */
    @Override
    public Page<CategoryEntity> SearchCategorys(PageInfo pageInfo) {
        Specification<CategoryEntity> specification = new Specification<CategoryEntity>() {

            @Override
            public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                criteriaQuery.where(predicate);
                return predicate;
            }
        };
        pageInfo.setSortName("cid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return categoryEntityRepo.findAll(specification, pageable);
    }

    /**
     * 通过cid 查找一级分类
     * @param cid
     * @return
     */
    @Override
    public CategoryEntity findCategory(Integer cid) {
        logger.info("通过cid查找{}",cid);
        if(cid ==null){
            return null;
        }
        return categoryEntityRepo.findByCid(cid);
    }

    /**
     * 更新一级分类
     * @param category
     * @return
     */
    @Override
    @Transactional
    public ActionResult updateCategory(CategoryEntity category) {
        if(category == null){
            return ActionResult.failure("一级分类不存在");
        }
        try {
            logger.info("待更新的一级分类{}",category);
            categoryEntityRepo.save(category);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("更新category出错{}",e);
            return ActionResult.failure("更新category出错");
        }
    }

    /**
     * 删除一级分类
     * @param categoryEntity
     * @param uid
     * @return
     */
    @Override
    @Transactional
    public ActionResult deleteCategory(CategoryEntity categoryEntity, Integer uid) {
        AdminEntity admin = adminEntityService.SearchAdmin(uid);
        if(admin == null){
            return ActionResult.failure("没有此权限");
        }
        try {
            logger.info("待删除的一级分类{}",categoryEntity);
            categoryEntityRepo.delete(categoryEntity);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("删除category出错{}",e);
            return ActionResult.failure("删除category出错");
        }
    }

    /**
     * 插入一级分类
     * @param categoryEntity
     * @return
     */
    @Override
    public ActionResult addCategory(CategoryEntity categoryEntity) {
        if(categoryEntity == null){
            return ActionResult.failure("一级分类不存在");
        }
        logger.info("待插入的一级分类{}",categoryEntity);
        categoryEntityRepo.save(categoryEntity);
        return ActionResult.SUCCESS;
    }

    /**
     * 查找所有一级分类
     * @return
     */
    @Override
    public List<CategoryEntity> findCatagorys() {
        return categoryEntityRepo.findAll();
    }

    /**
     * 根据cid，cname分页查询一级分类
     * @param cid
     * @param cname
     * @param pageInfo
     * @return
     */
    @Override
    public Page<CategoryEntity> findByCidAndCname(final Integer cid, final String cname, PageInfo pageInfo) {
        Specification<CategoryEntity> specification = new Specification<CategoryEntity>() {

            @Override
            public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _cid = root.get("cid");
                Predicate cid1 = criteriaBuilder.equal(_cid,cid);
                Path<String> _cname = root.get("cname");
                Predicate cname1 = criteriaBuilder.like(_cname,"%" + cname + "%");
                return criteriaBuilder.and(cid1,cname1);
            }
        };
        pageInfo.setSortName("cid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return categoryEntityRepo.findAll(specification, pageable);
    }

    /**
     *    通过 cname 分页查找商品
     * @param cname
     * @param pageInfo
     * @return
     */
    @Override
    public Page<CategoryEntity> findByCname(final String cname, PageInfo pageInfo) {
        Specification<CategoryEntity> specification = new Specification<CategoryEntity>() {

            @Override
            public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> _cname = root.get("cname");
                Predicate cname1 = criteriaBuilder.like(_cname,"%" + cname + "%");
                return cname1;
            }
        };
        pageInfo.setSortName("cid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return categoryEntityRepo.findAll(specification, pageable);
    }
}
