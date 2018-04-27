package com.ws.shop.service;

import com.ws.shop.entity.PacketEntity;

/**
 * packet service
 * @Author LQH
 * @date 2018年4月14日 21:25:11
 */
public interface PacketEntityService {

    /**
     * 根据uid查找packet
     * @param uid
     * @return
     */
    public PacketEntity findByUid(Integer uid);
}
