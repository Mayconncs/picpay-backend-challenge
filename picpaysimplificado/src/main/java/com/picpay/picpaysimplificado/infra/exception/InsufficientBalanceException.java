package com.picpay.picpaysimplificado.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InsufficientBalanceException extends RuntimeException{ 
    public InsufficientBalanceException(){
        super("Saldo insuficiente");
    }

    public InsufficientBalanceException(String message){
        super(message);
    }
}