package com.ws.shop.service.impl;

import com.ws.shop.entity.OrderItemEntity;
import com.ws.shop.repository.OrdersItemEntityRepo;
import com.ws.shop.service.OrderItemEntityService;
import com.ws.shop.utils.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemEntityServiceImpl implements OrderItemEntityService {
    private Logger logger = LoggerFactory.getLogger(OrderItemEntityServiceImpl.class);

    @Autowired
    OrdersItemEntityRepo ordersItemEntityRepo;

    @Override
    public List<OrderItemEntity> orderItemList(Integer pid) {
        return ordersItemEntityRepo.findByProduct(pid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult deleteOrderItem(OrderItemEntity orderItemEntity) {
        try {
            ordersItemEntityRepo.delteByItemId(orderItemEntity.getItemid());
        }catch (Exception e){
            logger.info("错误{}",e);
            return ActionResult.failure("删除orderitem失败");
        }
        return ActionResult.SUCCESS;
    }
}
