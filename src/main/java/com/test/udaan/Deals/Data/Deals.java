package com.test.udaan.Deals.Data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="deals")
@Data
public class Deals {

    @Id
    private int dealId;

    private String name;

    private String desc;
    private String type;
    private int sellerId;
    private int product_id;
    private int max_limit;
    private Date deal_end_time;
    private Boolean isActive;


}
