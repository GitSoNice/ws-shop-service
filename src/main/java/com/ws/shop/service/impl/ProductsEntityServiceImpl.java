package com.ws.shop.service.impl;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.AdminEntity;
import com.ws.shop.entity.CategoryEntity;
import com.ws.shop.entity.CategorySecondEntity;
import com.ws.shop.entity.ProductsEntity;
import com.ws.shop.repository.ProductsEntityRepo;
import com.ws.shop.service.AdminEntityService;
import com.ws.shop.service.ProductsEntityService;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品service
 * @Author lqh
 * @Date 2018年4月2日 22:02:33
 */
@Service
public class ProductsEntityServiceImpl implements ProductsEntityService{
    private Logger logger = LoggerFactory.getLogger(ProductsEntityServiceImpl.class);

    @Autowired
    ProductsEntityRepo productsEntityRepo;

    @Autowired
    AdminEntityService adminEntityService;

    @PersistenceContext
    private EntityManager em;

    /**
     * 分页查询csid下的商品
     * @param csid
     * @param pageInfo
     * @return
     */
    @Override
    public Page<ProductsEntity> findByCsid(final Integer csid, PageInfo pageInfo){
        Specification<ProductsEntity> specification = new Specification<ProductsEntity>() {

            @Override
            public Predicate toPredicate(Root<ProductsEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _csid = root.get("categorySecond").get("csid");
                Predicate csid1 = criteriaBuilder.equal(_csid, csid);
                return csid1;
            }
        };
        pageInfo.setSortName("pid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return productsEntityRepo.findAll(specification, pageable);

    }

    /**
     * 根据名字查找商品
     * @param name
     * @param pageInfo
     * @return
     */
    @Override
    public Page<ProductsEntity> findByName(final String name, PageInfo pageInfo) {
        Specification<ProductsEntity> specification = new Specification<ProductsEntity>() {

            @Override
            public Predicate toPredicate(Root<ProductsEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> _name = root.get("pname");
                Predicate name1 = criteriaBuilder.like(_name,"%" + name + "%");
                return name1;
            }
        };
        pageInfo.setSortName("pid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return productsEntityRepo.findAll(specification, pageable);
    }

    /**
     * 分页查询所有商品
     * @param pageInfo
     * @return
     */
    @Override
    public Page<ProductsEntity> SearchProducts(PageInfo pageInfo) {
        Specification<ProductsEntity> specification = new Specification<ProductsEntity>() {

            @Override
            public Predicate toPredicate(Root<ProductsEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                criteriaQuery.where(predicate);
                return predicate;
            }
        };
        pageInfo.setSortName("pid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return productsEntityRepo.findAll(specification, pageable);
    }

    /**
     * 通过pid pname csname 分页查找商品
     * @param pid
     * @param pname
     * @param csname
     * @param pageInfo
     * @return
     */
    @Override
    public Page<ProductsEntity> findByPidAndPnameAndCsname(final Integer pid,final String pname,final String csname, PageInfo pageInfo) {
        Specification<ProductsEntity> specification = new Specification<ProductsEntity>() {

            @Override
            public Predicate toPredicate(Root<ProductsEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _pid = root.get("pid");
                Predicate pid1 = criteriaBuilder.equal(_pid,pid);
                Path<String> _name = root.get("pname");
                Predicate name1 = criteriaBuilder.like(_name,"%" + pname + "%");
                Path<String> _csname = root.get("categorySecond").get("csname");
                Predicate csname1 = criteriaBuilder.like(_csname,"%"+csname+"%");
                return criteriaBuilder.and(pid1,name1,csname1);
            }
        };
        pageInfo.setSortName("pid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return productsEntityRepo.findAll(specification, pageable);
    }

    /**
     *    通过 pname csname 分页查找商品
     * @param pname
     * @param csname
     * @param pageInfo
     * @return
     */
    @Override
    public Page<ProductsEntity> findByPnameAndCsname(final String pname,final String csname, PageInfo pageInfo) {
        Specification<ProductsEntity> specification = new Specification<ProductsEntity>() {

            @Override
            public Predicate toPredicate(Root<ProductsEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<String> _name = root.get("pname");
                Predicate name1 = criteriaBuilder.like(_name,"%" + pname + "%");
                Path<String> _csname = root.get("categorySecond").get("csname");
                Predicate csname1 = criteriaBuilder.like(_csname,"%"+csname+"%");
                return criteriaBuilder.and(name1,csname1);
            }
        };
        pageInfo.setSortName("pid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return productsEntityRepo.findAll(specification, pageable);
    }

    /**
     * 分页查询cid下的商品
     * @param cid
     * @param pageInfo
     * @return
     */
    @Override
    public Page<ProductsEntity> findByCid(final Integer cid, PageInfo pageInfo){
        Specification<ProductsEntity> specification = new Specification<ProductsEntity>() {
            @Override
            public Predicate toPredicate(Root<ProductsEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _csid = root.get("cid");
                Predicate csid1 = criteriaBuilder.equal(_csid, cid);
                criteriaQuery.where(csid1);
                return csid1;
            }
        };
        pageInfo.setSortName("pid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return productsEntityRepo.findAll(specification, pageable);

    }

    /**
     * 查询热销商品十条
     * @param hot
     * @return
     */
    @Override
    public List<ProductsEntity> findHot(String hot) {
        return productsEntityRepo.findByIs_hot(hot);
    }

    /**
     * 查询最新商品
     * @return
     */
    @Override
    public List<ProductsEntity> findNew() {
        return productsEntityRepo.findNewProduct();
    }

    /**
     * 通过pid查找商品
     * @param pid
     * @return
     */
    @Override
    public ProductsEntity findByPid(Integer pid) {
        if(pid==null){
            ActionResult.failure("pid为空");
            return null;
        }
        return productsEntityRepo.findByPid(pid);
    }

    /**
     * 通过cid查找商品
     * @param cid
     * @return
     */
    @Override
    public Integer CountPageProductFromCategory(Integer cid) {
        if(cid==null){
            ActionResult.failure("cid为空");
            return null;
        }
        return productsEntityRepo.CountProductForCategory(cid);
    }

    /**
     * 通过csid查找商品
     * @param csid
     * @return
     */
    @Override
    public Integer CountPageProductFromCategorySecond(Integer csid) {
        if(csid==null){
            ActionResult.failure("csid为空");
            return null;
        }
        return productsEntityRepo.CountPageProductFromCategorySecond(csid);
    }

    /**
     *
     * @param product
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult updateProduct(ProductsEntity product) {
        if(product== null){
            return ActionResult.failure("商品不存在");
        }
        try {
            logger.info("待更新的商品{}",product);
            productsEntityRepo.save(product);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("更新product出错{}",e);
            return ActionResult.failure("更新出错");
        }

    }

    /**
     * 插入商品
     * @param product
     * @return
     */
    @Override
    public ActionResult saveProduct(ProductsEntity product) {
        logger.info("待插入的商品");
        productsEntityRepo.save(product);
        return ActionResult.SUCCESS;
    }

    /**
     * 删除商品
     * @param prodcut
     * @param uid
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult deleteProduct(ProductsEntity prodcut,Integer uid) {
        AdminEntity admin = adminEntityService.SearchAdmin(uid);
        if(admin == null){
            return ActionResult.failure("没有此权限");
        }
        try {
            logger.info("待删除的商品{}",prodcut);
            productsEntityRepo.delete(prodcut);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("删除product出错{}",e);
            return ActionResult.failure("删除出错");
        }

    }


}
