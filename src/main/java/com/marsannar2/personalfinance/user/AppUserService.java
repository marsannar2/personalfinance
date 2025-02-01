package com.marsannar2.personalfinance.user;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class AppUserService{

    @Autowired
    private AppUserRepository user_repo;

    
}
