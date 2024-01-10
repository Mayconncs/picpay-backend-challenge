package com.picpay.picpaysimplificado.infra.exception.handler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.picpay.picpaysimplificado.dtos.ExceptionDTO;
import com.picpay.picpaysimplificado.infra.exception.InsufficientBalanceException;
import com.picpay.picpaysimplificado.infra.exception.MerchantUserNotAuthorizedException;
import com.picpay.picpaysimplificado.infra.exception.NotificationServiceUnavailableException;
import com.picpay.picpaysimplificado.infra.exception.SelfTransactionException;
import com.picpay.picpaysimplificado.infra.exception.UnauthorizedTransactionException;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> handleDuplicateEntry(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já cadastrado", "409");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFound(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ExceptionDTO> handleInsufficientBalanceException(InsufficientBalanceException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "422");
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exceptionDTO);  
    }

    @ExceptionHandler(MerchantUserNotAuthorizedException.class)
    public ResponseEntity<ExceptionDTO> handleMerchantUserNotAuthorizedException(MerchantUserNotAuthorizedException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "403");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDTO);
    }

    @ExceptionHandler(SelfTransactionException.class)
    public ResponseEntity<ExceptionDTO> handleSelfTransactionException(SelfTransactionException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "403");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDTO);
    }

    @ExceptionHandler(UnauthorizedTransactionException.class)
    public ResponseEntity<ExceptionDTO> handleUnauthorizedTransactionException(UnauthorizedTransactionException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "403");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionDTO);
    }

    @ExceptionHandler(NotificationServiceUnavailableException.class)
    public ResponseEntity<ExceptionDTO> handleNotificationServiceUnavailableException(NotificationServiceUnavailableException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "503");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exceptionDTO);
    }

    @ExceptionHandler(Exception.class) 
    public ResponseEntity<ExceptionDTO> handleGeneralException(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(exception.getMessage(), "500");
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }
}
