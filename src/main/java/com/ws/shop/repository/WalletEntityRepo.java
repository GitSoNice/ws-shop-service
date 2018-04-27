package com.ws.shop.repository;

import com.ws.shop.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 *钱包dao
 * @Author lqh
 * @Date 2018年4月2日 21:31:13
 */
public interface WalletEntityRepo extends JpaRepository<WalletEntity,Long> {

    public WalletEntity findByUid(Integer uid);
}
