package com.marsannar2.personalfinance.expense;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marsannar2.personalfinance.user.AppUser;
import com.marsannar2.personalfinance.user.AppUserRepository;

@Service
public class ExpenseService {
    
    private final ExpenseRepository expense_repo;
    
    public ExpenseService(ExpenseRepository expense_repo,AppUserRepository user_repo){
        this.expense_repo = expense_repo;
    }

    @Transactional(readOnly=true)
    public List<Expense> getAllExpensesByUser(AppUser user){
        return expense_repo.findByUser(user);
    }
}
