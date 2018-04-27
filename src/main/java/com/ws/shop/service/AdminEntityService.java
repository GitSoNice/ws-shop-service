package com.ws.shop.service;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.AdminEntity;
import com.ws.shop.entity.UserEntity;
import com.ws.shop.utils.ActionResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminEntityService {

    /**
     * 验证admin的用户名和密码
     * @param admin
     * @return
     */
    public AdminEntity checkAdminUser(AdminEntity  admin);

    /**
     * 根据uid查找用户
     * @param uid
     * @return
     */

    public UserEntity SearchUser(Integer uid);

    /**
     * 根据uid查找管理员
     * @param uid
     * @return
     */
    public AdminEntity SearchAdmin(Integer uid);

    /**
     * 更新用户
     * @param user
     */
    public ActionResult updateUser(UserEntity user);
}
