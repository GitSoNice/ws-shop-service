package com.ws.shop.service.impl;

import com.ws.shop.entity.WalletEntity;
import com.ws.shop.repository.WalletEntityRepo;
import com.ws.shop.service.WalletEntityService;
import com.ws.shop.utils.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletEntityServiceImpl implements WalletEntityService {

    @Autowired
    WalletEntityRepo walletEntityRepo;

    @Override
    public WalletEntity findByUid(Integer uid) {
        if(uid == null){
            return null;
        }
        return walletEntityRepo.findByUid(uid);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public ActionResult updateWallet(WalletEntity walletEntity) {
        if(walletEntity ==null){
            return ActionResult.failure("不存在钱包");
        }
        walletEntityRepo.save(walletEntity);
        return ActionResult.SUCCESS;
    }
}
