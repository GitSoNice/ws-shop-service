package com.ws.shop.repository;

import com.ws.shop.entity.OrderItemEntity;
import com.ws.shop.entity.OrdersEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 订单dao
 * @Author lqh
 * @Date 2018年4月2日 21:28:16
 */
public interface OrdersEntityRepo extends JpaRepository<OrdersEntity,Long>,JpaSpecificationExecutor<OrdersEntity> {

    /**
     * 通过oid查找
     * @param oid
     */
    public OrdersEntity findByOid(Integer oid);

    /**
     * 查找所有数量
     * @return
     */
    @Query(nativeQuery = true,value = "select count(*) from orders")
    public int countAll();

    /**
     *通过uid
     * @param uid
     * @return
     */
    public int countByUser(Integer uid);

    /**
     * 查找所有订单项
     * @param oid
     * @return
     */
    @Query(nativeQuery = true, value ="select * from orderitem oi where oi.oid=?")
    public List<OrderItemEntity> findOrderItem(Integer oid);

}
