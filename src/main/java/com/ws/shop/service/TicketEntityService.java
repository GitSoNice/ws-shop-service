package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.TicketEntity;
import org.springframework.data.domain.Page;

/**
 * 优惠券Service
 * @Author LQH
 * @date 2018年4月14日 21:19:36
 */
public interface TicketEntityService {

    /**
     * 通过cid查找ticket
     * @param cid
     * @return
     */
    public TicketEntity findByCid(Integer cid);

    public Page<TicketEntity> findByPacid(final Integer pacid,PageInfo pageInfo);

}
