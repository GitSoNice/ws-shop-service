package com.ws.shop.service.impl;

import com.ws.shop.entity.PacketEntity;
import com.ws.shop.repository.PacketEntityRepo;
import com.ws.shop.service.PacketEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacketEntityServiceImpl implements PacketEntityService {

    @Autowired
    PacketEntityRepo packetEntityRepo;

    @Override
    public PacketEntity findByUid(Integer uid) {
        if(uid == null){
            return null;
        }
        return packetEntityRepo.findByUid(uid);
    }
}
