package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.UserEntity;
import com.ws.shop.utils.ActionResult;
import org.springframework.data.domain.Page;

import java.io.InputStream;

public interface UserEntityService {

    /**
     *根据激活码查询用户
     * @param code
     * @return
     */
   /* public UserEntity active(String code);*/

    /**
     * 通过用户名、密码查找用户
     * @param user
     * @return
     */
    public UserEntity findUserByUsernameAndPassword(UserEntity user);

    /**
     * 根据用户名判断用户是否存在
     * @param userName
     * @return
     */
    public UserEntity existUser(String userName);

    /**
     * 注册用户
     *
     * @param user
     */
    public ActionResult register(UserEntity user);

    /**
     *更新用户
     * @param user
     */
    public ActionResult update(UserEntity user);

    /**
     * 根据用户uid的值查询用户
     *
     * @param uid
     * @return
     */
    public UserEntity findByUid(Integer uid);

    /**
     * 查看所有user分页
     * @param pageInfo
     * @return
     */
    public Page<UserEntity> SearchUsers(PageInfo pageInfo);

    /**
     * 根据用户名查找用户并分页
     * @param username
     * @param pageInfo
     * @return
     */
    public Page<UserEntity> findByUserName(final String username, PageInfo pageInfo);

    /**
     * 用户信息导出exccel
     * @return
     * @throws Exception
     */
    public InputStream getInputStream() throws Exception;
}
