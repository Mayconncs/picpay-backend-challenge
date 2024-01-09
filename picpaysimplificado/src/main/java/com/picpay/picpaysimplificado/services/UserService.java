package com.picpay.picpaysimplificado.services;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.picpay.picpaysimplificado.domain.user.User;
import com.picpay.picpaysimplificado.domain.user.UserType;
import com.picpay.picpaysimplificado.dtos.UserDTO;
import com.picpay.picpaysimplificado.infra.exception.InsufficientBalanceException;
import com.picpay.picpaysimplificado.infra.exception.MerchantUserNotAuthorizedException;
import com.picpay.picpaysimplificado.infra.exception.SelfTransactionException;
import com.picpay.picpaysimplificado.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User createUserInternal(UserDTO userDTO) {
        User user = new User(userDTO);
        return userRepository.save(user);
    }

    public void validationTransaction(User sender, User receiver, BigDecimal value) throws Exception {      
        if(sender.getUserType() == UserType.LOGISTA) {
            throw new MerchantUserNotAuthorizedException("Logistas não podem efetuar transferências");
        }

        if(sender.getBalance().compareTo(value) < 0) {
            throw new InsufficientBalanceException("Saldo insuficiente");
        }

        if(sender.getId() == receiver.getId()) {
            throw new SelfTransactionException("Não é possível realizar transações para si próprio");
        }
    }

    public User findUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        } 

        User user = optionalUser.get();
        return user;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
}
