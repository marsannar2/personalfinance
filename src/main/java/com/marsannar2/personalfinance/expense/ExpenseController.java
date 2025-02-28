package com.marsannar2.personalfinance.expense;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marsannar2.personalfinance.user.AppUser;
import com.marsannar2.personalfinance.user.AppUserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/budget")
public class ExpenseController {

    private final AppUserService user_service;
    private final ExpenseService expense_service;

    public ExpenseController(AppUserService user_service,ExpenseService expense_service){
        this.user_service = user_service;
        this.expense_service = expense_service;
    }

    @GetMapping("")
    public ResponseEntity getAllExpensesByUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String principal_username = authentication.getName();
        AppUser user= user_service.findByUsername(principal_username);
        List<Expense> expenses = expense_service.getAllExpensesByUser(user);
        
        return new ResponseEntity<>(expenses,HttpStatus.OK);

    }
    
}
