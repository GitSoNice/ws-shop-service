package com.ws.shop.service.impl;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.UserEntity;
import com.ws.shop.repository.UserEntityRepo;
import com.ws.shop.service.UserEntityService;
import com.ws.shop.utils.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 用户service
 * @Author lqh
 * @Date 2018年4月2日 22:02:14
 */
@Service
public class UserEntityServiceImpl implements UserEntityService {
    private Logger logger = LoggerFactory.getLogger(UserEntityServiceImpl.class);

    @Autowired
    UserEntityRepo userEntityRepo;

   /* public UserEntity active(String code) {
        logger.info("开始查找user，通过激活码{}",code);
        return userEntityRepo.findByCode(code);
    }*/

    /**
     * 通过用户名密码查询
     * @param user
     * @return
     */
    @Override
    public UserEntity findUserByUsernameAndPassword(UserEntity user) {
        logger.info("开始查找user，通过用户名密码{}",user);
        return userEntityRepo.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    /**
     * 判断用户是否存在
     * @param userName
     * @return
     */
    @Override
    public UserEntity existUser(String userName) {
        logger.info("开始判断用户是否存在{}",userName);
        return userEntityRepo.findByUsername(userName);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public ActionResult register(UserEntity user) {
        user.setState(1);
        userEntityRepo.save(user);
        return ActionResult.SUCCESS;
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ActionResult update(UserEntity user) {
        if(user == null){
            ActionResult.failure("user is null");
        }
        try{
            logger.info("待更新的用户{}",user);
            userEntityRepo.save(user);
            logger.info("更新成功！");
            return ActionResult.SUCCESS;
        }catch (Exception e){
            logger.info("更新user出错{}",user);
            return ActionResult.error("更新user出错");
        }

    }

    /**
     * 通过uid查找用户
     * @param uid
     * @return
     */
    @Override
    public UserEntity findByUid(Integer uid) {
        if(uid==null){
            ActionResult.failure("uid为空");
            return null;
        }
        return userEntityRepo.findByUid(uid);
    }

    /**
     * 分页查找所有用户
     * @param pageInfo
     * @return
     */
    @Override
    public Page<UserEntity> SearchUsers(PageInfo pageInfo) {
        Specification<UserEntity> specification = new Specification<UserEntity>() {

            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                criteriaQuery.where(predicate);
                return predicate;
            }
        };
        pageInfo.setSortName("uid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return userEntityRepo.findAll(specification, pageable);
    }
}
