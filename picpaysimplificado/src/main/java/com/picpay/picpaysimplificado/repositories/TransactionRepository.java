package com.picpay.picpaysimplificado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.picpay.picpaysimplificado.domain.transaction.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
