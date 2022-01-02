package com.test.udaan.Deals.service;

import com.test.udaan.Deals.pojo.request.CreateDeal;

public interface DealService {

    public Object createDeal(CreateDeal createDeal);

    public Boolean activateOrDeactivateDeal(Integer dealId, Boolean isActive);

    public Object applyDeal(Integer dealId, Integer userId);

}
