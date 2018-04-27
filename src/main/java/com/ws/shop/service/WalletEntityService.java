package com.ws.shop.service;

import com.ws.shop.entity.ProductsEntity;
import com.ws.shop.entity.WalletEntity;
import com.ws.shop.utils.ActionResult;

public interface WalletEntityService {

    public WalletEntity findByUid(Integer uid);

    /**
     * 更新钱包的信息
     * @param walletEntity
     */
    public ActionResult updateWallet(WalletEntity walletEntity);

}
