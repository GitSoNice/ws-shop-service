package com.ws.shop.repository;

import com.ws.shop.entity.PacketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 卡包dao
 * @Author lqh
 * @Date 2018年4月2日 21:29:10
 */
public interface PacketEntityRepo extends JpaRepository<PacketEntity,Long> {

    /**
     * 通过uid
     * @param uid
     * @return
     */
    public PacketEntity findByUid(Integer uid);
}
