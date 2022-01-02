package com.test.udaan.Deals.Data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Repository
public interface DealRepository extends CrudRepository<Deals, Serializable> {

    @Query("update deals set isActive = ?1 where id =?2")
    public Deals activateOrdeactivatedeal(Boolean isActive, Integer dealId);

    @Query("update deals set max_limit = ?1 where id =?2")
    public Deals updateDealUserLimit(Integer max_limit, Integer dealId);

    @Query("update deals set deal_end_time = ?1 where id =?2")
    public Deals updateDealEndTime(Date deal_end_time, Integer dealId);

    @Query("select * from  deals where id =?1")
    public Deals getDeal(Integer dealId);

    @Query("select * from  deals ")
    public List<Deals> getAllActiveDeals();
}
