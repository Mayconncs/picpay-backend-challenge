package com.picpay.picpaysimplificado.services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.picpay.picpaysimplificado.domain.transaction.Transaction;
import com.picpay.picpaysimplificado.domain.user.User;
import com.picpay.picpaysimplificado.dtos.TransactionDTO;
import com.picpay.picpaysimplificado.infra.exception.UnauthorizedTransactionException;
import com.picpay.picpaysimplificado.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository  transactionRepository;

    @Autowired
    private AuthorizationService authorization;

    @Autowired
    private NotificationService notificationService;

    public Transaction createTransactionInternal(TransactionDTO transactionDTO) throws Exception {
        User payer = userService.findUserById(transactionDTO.payer());
        User payee = userService.findUserById(transactionDTO.payee());

        userService.validationTransaction(payer, payee, transactionDTO.value());

        Boolean isAuthorization = authorization.authorizeTransaction();
        if(!isAuthorization) {
            throw new UnauthorizedTransactionException("Transação não autorizada");
        }

        Transaction transaction = new Transaction();
        transaction.setPayee(payee);
        transaction.setPayer(payer);
        transaction.setTimeStamp(LocalDateTime.now());
        transaction.setValue(transactionDTO.value());
        transactionRepository.save(transaction);

        payer.setBalance(payer.getBalance().subtract(transactionDTO.value()));
        payee.setBalance(payee.getBalance().add(transactionDTO.value()));
        userService.saveUser(payer);
        userService.saveUser(payee);

        this.notificationService.sendNotification(payer, "Transação realizada com sucesso");
        this.notificationService.sendNotification(payee, "Transação recebida com sucesso");

        return transaction;
    }
}
