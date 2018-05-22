package com.ws.shop.service.impl;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.AdminEntity;
import com.ws.shop.entity.OrderItemEntity;
import com.ws.shop.entity.OrdersEntity;
import com.ws.shop.entity.ProductsEntity;
import com.ws.shop.repository.OrdersEntityRepo;
import com.ws.shop.service.AdminEntityService;
import com.ws.shop.service.OrderEntityService;
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

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class OrderEntityServiceImpl implements OrderEntityService{
    private Logger logger = LoggerFactory.getLogger(OrderEntityServiceImpl.class);

    @Autowired
    OrdersEntityRepo ordersEntityRepo;

    @Autowired
    AdminEntityService adminEntityService;

    /**
     * 插入订单
     * @param order
     * @return
     */
    public ActionResult saveOrders(OrdersEntity order) {
        logger.info("待插入的order{}",order);
        ordersEntityRepo.save(order);
        return ActionResult.SUCCESS;
    }

    /**
     * 通过uid分页查找
     * @param uid
     * @param pageInfo
     * @return
     */
    public Page<OrdersEntity> findByUid(final Integer uid, PageInfo pageInfo) {
        Specification<OrdersEntity> specification = new Specification<OrdersEntity>() {

            @Override
            public Predicate toPredicate(Root<OrdersEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _uid = root.get("user").get("uid");
                Predicate uid1 = criteriaBuilder.equal(_uid, uid);
                return uid1;
            }
        };
        pageInfo.setSortName("oid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return ordersEntityRepo.findAll(specification, pageable);
    }

    /**
     * 通过oid查找订单
     * @param oid
     * @return
     */
    public OrdersEntity findByOid(Integer oid) {
        if(oid == null){
            ActionResult.failure("oid为空");
            return null;
        }
        return ordersEntityRepo.findByOid(oid);
    }

    /**
     * 更新订单
     * @param order
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult update(OrdersEntity order) {
        if(order == null){
            return ActionResult.failure("不存在订单");
        }
        try {
            logger.info("待更新order{}",order);
            ordersEntityRepo.save(order);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("更新order出错{}",e);
            return ActionResult.failure("更新出错");
        }
    }

    /**
     * 分页查找所有订单
     * @param pageInfo
     * @return
     */
    @Override
    public Page<OrdersEntity> SearchOrders(PageInfo pageInfo) {
        Specification<OrdersEntity> specification = new Specification<OrdersEntity>() {

            @Override
            public Predicate toPredicate(Root<OrdersEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                criteriaQuery.where(predicate);
                return predicate;
            }
        };
        pageInfo.setSortName("oid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return ordersEntityRepo.findAll(specification, pageable);
    }

    /**
     * 查找所有订单项
     * @param oid
     * @return
     */
    @Override
    public List<OrderItemEntity> findOrderItem(Integer oid) {
        if(oid == null){
            return null;
        }
        return ordersEntityRepo.findOrderItem(oid);
    }

    /**
     * 通过uid查找
     * @param uid
     * @return
     */
    @Override
    public Integer findCountByUid(Integer uid) {
        return ordersEntityRepo.countByUser(uid);
    }

    /**
     * 删除订单
     * @param ordersEntity
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult deleteOrder(OrdersEntity ordersEntity,Integer uid) {
        AdminEntity admin = adminEntityService.SearchAdmin(uid);
        if(admin == null){
            return ActionResult.failure("没有此权限");
        }
        try {
            logger.info("待删除的订单{}",ordersEntity);
            ordersEntityRepo.delete(ordersEntity);
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("删除ordersEntity出错{}",e);
            return ActionResult.failure("删除ordersEntity出错");
        }
    }

    @Override
    public Page<OrdersEntity> findByOidAndUid(final Integer oid,final Integer uid, PageInfo pageInfo) {
        Specification<OrdersEntity> specification = new Specification<OrdersEntity>() {

            @Override
            public Predicate toPredicate(Root<OrdersEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _oid = root.get("oid");
                Predicate oid1 = criteriaBuilder.equal(_oid, oid );
                Path<Integer> _uid = root.get("user").get("uid");
                Predicate uid1 = criteriaBuilder.equal(_uid,uid);
                return criteriaBuilder.and(oid1,uid1);
            }
        };
        pageInfo.setSortName("oid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return ordersEntityRepo.findAll(specification, pageable);
    }

    @Override
    public Page<OrdersEntity> adminFindByOid(final Integer oid, PageInfo pageInfo) {
        Specification<OrdersEntity> specification = new Specification<OrdersEntity>() {

            @Override
            public Predicate toPredicate(Root<OrdersEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _oid = root.get("oid");
                Predicate oid1 = criteriaBuilder.equal(_oid, oid );
                return oid1;
            }
        };
        pageInfo.setSortName("oid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return ordersEntityRepo.findAll(specification, pageable);
    }

    @Override
    public Page<OrdersEntity> adminFindByUid(final Integer uid, PageInfo pageInfo) {
        Specification<OrdersEntity> specification = new Specification<OrdersEntity>() {

            @Override
            public Predicate toPredicate(Root<OrdersEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _uid = root.get("user").get("uid");
                Predicate uid1 = criteriaBuilder.equal(_uid,uid);
                return uid1;
            }
        };
        pageInfo.setSortName("oid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return ordersEntityRepo.findAll(specification, pageable);
    }
}
