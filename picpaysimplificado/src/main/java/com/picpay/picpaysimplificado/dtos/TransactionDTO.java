package com.picpay.picpaysimplificado.dtos;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotNull;

public record TransactionDTO(@NotNull BigDecimal value, @NotNull Long payer, @NotNull Long payee) {
    
}
