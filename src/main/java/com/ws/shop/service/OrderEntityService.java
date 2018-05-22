package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.OrderItemEntity;
import com.ws.shop.entity.OrdersEntity;
import com.ws.shop.utils.ActionResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderEntityService {

    /**
     * 保存订单
     * @param order
     */
    public ActionResult saveOrders(OrdersEntity order);

    /**
     * 根据用户id查询订单,带分页
     * @param uid
     * @param pageInfo
     * @return
     */
    public Page<OrdersEntity> findByUid(final Integer uid, PageInfo pageInfo) ;

    /**
     * 根据订单id查询订单
     * @param oid
     * @return
     */
    public OrdersEntity findByOid(Integer oid);

    /**
     * 修改订单
     * @param order
     */
    public ActionResult update(OrdersEntity order);

    /**
     * 分页查找订单
     * @param pageInfo
     * @return
     */
    public Page<OrdersEntity> SearchOrders(PageInfo pageInfo);

    /**
     * 查找所有订单项
     * @param oid
     * @return
     */
    public List<OrderItemEntity> findOrderItem(Integer oid);

    /**
     * 查找订单数量
     * @param uid
     * @return
     */
    public Integer findCountByUid(Integer uid);

    /**
     * 删除订单
     * @param ordersEntity
     * @return
     */
    public ActionResult deleteOrder(OrdersEntity ordersEntity,Integer uid);

    /**
     * 根据订单编号和用户编号查询订单
     * @param oid
     * @param uid
     * @param pageInfo
     * @return
     */
    public Page<OrdersEntity> findByOidAndUid(final Integer oid, final Integer uid,PageInfo pageInfo);

    /**
     * 根据订单编号查询订单
     * @param oid
     * @param pageInfo
     * @return
     */
    public Page<OrdersEntity> adminFindByOid(final Integer oid,PageInfo pageInfo);

    /**
     * 根据订单编号查询订单
     * @param uid
     * @param pageInfo
     * @return
     */
    public Page<OrdersEntity> adminFindByUid(final Integer uid,PageInfo pageInfo);
}