package com.picpay.picpaysimplificado.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class SelfTransactionException extends Exception { 
    public SelfTransactionException() {
        super("Não é possível realizar transações para si próprio");
    }

    public SelfTransactionException(String message) {
        super(message);
    }
}
