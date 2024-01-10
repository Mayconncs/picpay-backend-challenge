package com.picpay.picpaysimplificado.infra.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class MerchantUserNotAuthorizedException extends RuntimeException {
    public MerchantUserNotAuthorizedException() {
        super("Logistas não podem efetuar transferências");
    }

    public MerchantUserNotAuthorizedException(String message) {
        super(message);
    }
}
