package com.ws.shop.repository;

import com.ws.shop.entity.OrderItemEntity;
import com.ws.shop.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 订单dao
 * @Author lqh
 * @Date 2018年4月2日 21:28:16
 */
public interface OrdersItemEntityRepo extends JpaRepository<OrderItemEntity,Long> {

    /**
     * 通过pid查找
     * @param pid
     */
    @Query(nativeQuery = true,value = "select * from orderItem where pid=?")
    public List<OrderItemEntity> findByProduct(Integer pid);

    @Query(nativeQuery = true,value = "delete from orderitem where itemid=?")
    @Modifying
    public void delteByItemId(Integer itemid);

}
