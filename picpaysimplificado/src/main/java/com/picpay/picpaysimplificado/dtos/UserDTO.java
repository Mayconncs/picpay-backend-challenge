package com.picpay.picpaysimplificado.dtos;

import java.math.BigDecimal;
import com.picpay.picpaysimplificado.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String identity, @NotBlank String email, @NotBlank String password, UserType userType, @NotNull BigDecimal balance) {
    
}
