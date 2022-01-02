package com.test.udaan.Deals.pojo.response;

import lombok.Data;

@Data
public class ApiResponse {


    String message;

    int status;
    public ApiResponse(){

    }
    public ApiResponse(String message, int status){
        this.message = message;
        this.status = status;
    }

}
