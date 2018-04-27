package com.ws.shop.repository;

import com.ws.shop.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户dao
 * @Author lqh
 * @Date 2018年4月2日 21:30:19
 */
public interface UserEntityRepo extends JpaRepository<UserEntity,Long>,JpaSpecificationExecutor<UserEntity>{

    /**
     * 查看数量
     * @return
     */
    @Query(nativeQuery = true,value = "select count (*) from user")
    public int countAll();

    /**
     * 通过用户名
     * @param username
     * @return
     */
    public UserEntity findByUsername(String username);

    /**
     * 用户名和密码
     * @param username
     * @param password
     * @return
     */
    public UserEntity findByUsernameAndPassword(String username,String password);


    /**
     * 用户id
     * @param uid
     * @return
     */
    public UserEntity findByUid(Integer uid);

}
