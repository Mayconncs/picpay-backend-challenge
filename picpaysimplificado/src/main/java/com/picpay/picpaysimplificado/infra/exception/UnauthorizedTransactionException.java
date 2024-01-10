package com.picpay.picpaysimplificado.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthorizedTransactionException extends RuntimeException {
    public UnauthorizedTransactionException() {
        super("Transação não autorizada");
    }

    public UnauthorizedTransactionException(String message) {
        super(message);
    }
}