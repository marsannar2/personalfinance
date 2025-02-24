package com.marsannar2.personalfinance.utils.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResponse {

    @JsonProperty("message")
    private String message;

    public MessageResponse(String message){
        this.message = message;
    }

    
}
