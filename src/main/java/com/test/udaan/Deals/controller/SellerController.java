package com.test.udaan.Deals.controller;


import com.test.udaan.Deals.pojo.request.CreateDeal;
import com.test.udaan.Deals.pojo.request.CreateSeller;
import com.test.udaan.Deals.pojo.response.ApiResponse;
import com.test.udaan.Deals.service.DealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@Slf4j
public class SellerController {


    @Autowired
    DealService dealService;


    @RequestMapping(value = "/create-seller", method = RequestMethod.POST)
    public Response<ApiResponse> createSeller(@RequestBody CreateSeller createSeller ){


        return null;
    }

    @RequestMapping(value = "/create-deal", method = RequestMethod.POST)
    public ApiResponse createDeal(@RequestBody CreateDeal createDeal ){


        Object result = null;
        ApiResponse apiResponse = new ApiResponse();
        try{
            result  =dealService.createDeal(createDeal);

            apiResponse.setMessage(result.toString());
            apiResponse.setStatus(200);
        } catch(Exception exp){
            log.error("[Controller: createSeller] exception while creating deals :" +exp);
            apiResponse.setMessage("Something went wrong, please again");
            apiResponse.setStatus(500);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/apply-deal", method = RequestMethod.POST)
    public ApiResponse applyDeal(Integer dealId, Integer userId ){


        Object result = null;
        ApiResponse apiResponse = new ApiResponse();
        try{
            result  =dealService.applyDeal( dealId, userId );

            apiResponse.setMessage(result.toString());
            apiResponse.setStatus(200);
        } catch(Exception exp){
            log.error("[Controller: createSeller] exception while creating deals :" +exp);
            apiResponse.setMessage("Something went wrong, please again");
            apiResponse.setStatus(500);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/activate-or-deactivate-deal", method = RequestMethod.POST)
    public ApiResponse activateOrDeactivateDeals(Integer dealId, Boolean isActive){


        Object result = null;
        ApiResponse apiResponse = new ApiResponse();
        try{
            result  =dealService.activateOrDeactivateDeal(dealId, isActive);

            apiResponse.setMessage(result.toString());
            apiResponse.setStatus(200);
        } catch(Exception exp){
            log.error("[Controller: createSeller] exception while creating deals :" +exp);
            apiResponse.setMessage("Something went wrong, please again");
            apiResponse.setStatus(500);
        }
        return apiResponse;
    }

}
