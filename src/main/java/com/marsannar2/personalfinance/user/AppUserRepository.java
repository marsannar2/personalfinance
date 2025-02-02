package com.marsannar2.personalfinance.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface AppUserRepository extends CrudRepository<AppUser,Integer>{
    
    Optional<AppUser> findByUsername(String username);

}
