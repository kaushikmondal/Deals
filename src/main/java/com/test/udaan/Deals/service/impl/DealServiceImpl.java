package com.test.udaan.Deals.service.impl;

import com.test.udaan.Deals.Data.DealRepository;
import com.test.udaan.Deals.Data.Deals;
import com.test.udaan.Deals.pojo.request.CreateDeal;
import com.test.udaan.Deals.service.DealService;
import com.test.udaan.Deals.validator.ValidateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.UUID;

@Service
@Slf4j
public class DealServiceImpl implements DealService {

    @Autowired
    DealRepository dealRepo;

    @Autowired
    ValidateRequest validateRequest;

    @Override
    public Object createDeal( CreateDeal createDeal) {

        Object result = null;
        try {
            //validateRequest

            Deals deal = prepareDealDataToSave(createDeal);
            result= dealRepo.save(deal);
        }catch(Exception exp){
            log.info("Exception while creating deal: "+exp);
        }

        return result;
    }

    @Override
    public Boolean activateOrDeactivateDeal(Integer dealId, Boolean isActive) {

        Boolean status=false;
        try{
            dealRepo.activateOrdeactivatedeal(isActive, dealId);
            status = true;
        } catch(Exception exp){
            log.error("[activateOrDeactivateDeal]Error: "+exp);
        }

        return status;
    }

    @Override
    public Object applyDeal(Integer dealId, Integer userId) {
        Object result = null;
        try{

            Deals deal = dealRepo.getDeal(dealId);
            if(!deal.getIsActive()){
                throw new Exception("Deal is not active anymore");
            }
            validateDealIfApplicable(deal);


        }catch(Exception exp){
            log.error("[applyDeal] error: "+exp);
        }
        return result;
    }


    private Deals prepareDealDataToSave(CreateDeal createDeal){
        Deals deal = new Deals();
        deal.setName(createDeal.getDealName());
        deal.setDesc(createDeal.getDealDesc());
        deal.setSellerId(createDeal.getSellerId());
        deal.setProduct_id(createDeal.getProductId());
        deal.setType(createDeal.getDealType());
        deal.setDeal_end_time(createDeal.getDelaEndTime());
        deal.setMax_limit(createDeal.getMaxLimit());
        deal.setIsActive(true);
        return deal;
    }
    public void validateDealIfApplicable(Deals deal) throws Exception {

        if(!deal.getIsActive()){
            throw new Exception("Deal is not active anymore");
        }
        //diff curr time- deal_end_time

    }
}
