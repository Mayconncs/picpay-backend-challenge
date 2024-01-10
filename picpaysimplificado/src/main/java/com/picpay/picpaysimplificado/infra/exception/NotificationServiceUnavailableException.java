package com.picpay.picpaysimplificado.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class NotificationServiceUnavailableException extends RuntimeException {
    public NotificationServiceUnavailableException() {
        super("O serviço de notificação está fora do ar");
    }
    public NotificationServiceUnavailableException(String message) {
        super(message);
    }
}
