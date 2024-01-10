package com.picpay.picpaysimplificado.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picpay.picpaysimplificado.domain.transaction.Transaction;
import com.picpay.picpaysimplificado.dtos.TransactionDTO;
import com.picpay.picpaysimplificado.services.TransactionService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    @Transactional
    public ResponseEntity<Transaction> createTransaction(@RequestBody @Valid TransactionDTO transactionDTO) throws Exception {
        Transaction transaction = transactionService.createTransactionInternal(transactionDTO);
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
    
}
