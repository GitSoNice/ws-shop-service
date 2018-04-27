package com.ws.shop.service.impl;

import com.ws.shop.bean.PageInfo;
import com.ws.shop.entity.TicketEntity;
import com.ws.shop.entity.UserEntity;
import com.ws.shop.repository.TicketEntityRepo;
import com.ws.shop.service.TicketEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;

@Service
public class TicketEntityServiceImpl implements TicketEntityService {

    @Autowired
    TicketEntityRepo ticketEntityRepo;

    @Override
    public TicketEntity findByCid(Integer cid) {
        if(cid == null){
            return null;
        }
        return ticketEntityRepo.findByCid(cid);
    }

    @Override
    public Page<TicketEntity> findByPacid(final Integer pacid,PageInfo pageInfo) {
        Specification<TicketEntity> specification = new Specification<TicketEntity>() {

            @Override
            public Predicate toPredicate(Root<TicketEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Integer> _pacid = root.get("packetEntity").get("pacid");
                Predicate pacid1 = criteriaBuilder.equal(_pacid, pacid);
                return pacid1;
            }
        };
        pageInfo.setSortName("tid");
        Sort sort = new Sort(Sort.Direction.DESC, pageInfo.getSortName());
        Pageable pageable = new PageRequest(pageInfo.getPage(), pageInfo.getSize(), sort);
        return ticketEntityRepo.findAll(specification, pageable);
    }
}
