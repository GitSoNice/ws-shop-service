package com.ws.shop.repository;

import com.ws.shop.entity.CategoryEntity;
import com.ws.shop.entity.ProductsEntity;
import com.ws.shop.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 优惠券dao
 * @Author lqh
 * @Date 2018年4月2日 21:30:00
 */
public interface TicketEntityRepo extends JpaRepository<TicketEntity,Long>,JpaSpecificationExecutor<TicketEntity> {

    /**
     * 通过cid查找
     * @param cid
     * @return
     */
    @Query(nativeQuery = true,value = "select * from ticket where cid=?")
    public TicketEntity findByCid(Integer cid);
}
