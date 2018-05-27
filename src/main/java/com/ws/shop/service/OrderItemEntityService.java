package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.OrderItemEntity;
import com.ws.shop.entity.OrdersEntity;
import com.ws.shop.utils.ActionResult;
import org.springframework.data.domain.Page;

import java.io.InputStream;
import java.util.List;

public interface OrderItemEntityService {
    /**
     * 根据pid查找orderItem
     * @param pid
     * @return
     */
    public List<OrderItemEntity> orderItemList(Integer pid);

    /**
     * 删除item
     * @param orderItemEntity
     * @return
     */
    public ActionResult deleteOrderItem(OrderItemEntity orderItemEntity);
}