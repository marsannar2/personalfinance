package com.marsannar2.personalfinance.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;


@Repository
public interface AppUserRepository extends CrudRepository<AppUser,Integer>{
    
    Optional<AppUser> findByEmail(String email);
}
