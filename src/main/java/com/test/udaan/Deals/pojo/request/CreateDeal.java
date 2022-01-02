package com.test.udaan.Deals.pojo.request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateDeal {
    String dealName;
    String dealDesc;
    String dealType;
    Integer sellerId;
    Integer productId;
    Integer maxLimit;
    Date  delaEndTime;
    Boolean isActive;
}
