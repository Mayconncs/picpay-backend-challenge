    package com.picpay.picpaysimplificado.repositories;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;
    import com.picpay.picpaysimplificado.domain.user.User;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long>{
        
    }