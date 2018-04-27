package com.ws.shop.service.impl;

import com.ws.shop.entity.AdminEntity;
import com.ws.shop.entity.UserEntity;
import com.ws.shop.repository.AdminEntityRepo;
import com.ws.shop.repository.UserEntityRepo;
import com.ws.shop.service.AdminEntityService;
import com.ws.shop.utils.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *管理员service
 * @Author lqh
 * @Date 2018年4月2日 21:31:38
 */
@Service
public class AdminEntityServiceImpl implements AdminEntityService {

    private Logger logger = LoggerFactory.getLogger(AdminEntityServiceImpl.class);
    @Autowired
    AdminEntityRepo adminEntityRepo;

    @Autowired
    UserEntityRepo userEntityRepo;

    @Override
    public  AdminEntity checkAdminUser(AdminEntity admin) {
        logger.info("检查用户名密码{}",admin);
        if(admin == null){
            logger.info("admin为空{}",admin);
            return null;
        }
        return adminEntityRepo.findByUsernameAndPassword(admin.getUsername(),admin.getPassword());
    }

    @Override
    public UserEntity SearchUser(Integer uid) {
        logger.info("通过uid查找用户{}",uid);
        return userEntityRepo.findByUid(uid);
    }

    @Override
    public AdminEntity SearchAdmin(Integer uid) {
        logger.info("通过uid找管理员{}",uid);
        if(uid == null){
            logger.info("找不到该管理员{}",uid);
            return null;
        }
        return adminEntityRepo.findByUid(uid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult updateUser(UserEntity user) {
        logger.info("尝试更新数据{}",user);
        if(user ==null){
            return ActionResult.failure("用户信息为空");
        }
        try {
            logger.info("待更新用户{}",user);
            userEntityRepo.save(user);
            return ActionResult.SUCCESS;
        }catch (Exception e ){
            logger.info("更新user出错{}",e);
            return ActionResult.error("更新user出错");
        }
    }

}
