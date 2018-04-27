package com.ws.shop.repository;

import com.ws.shop.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 管理员dao
 * @Author lqh
 * @Date 2018年4月2日 21:25:13
 */
public interface AdminEntityRepo extends JpaRepository<AdminEntity,Long> {

    /**
     * 通过用户名和密码查找管理员
     * @param name
     * @param password
     * @return
     */
    public AdminEntity findByUsernameAndPassword(String name , String password);

    /**
     * 通过管理员id来查找
     * @param uid
     * @return
     */
    public AdminEntity findByUid(Integer uid);

}
