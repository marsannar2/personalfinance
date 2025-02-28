package com.marsannar2.personalfinance.expense;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.marsannar2.personalfinance.user.AppUser;


@Repository
public interface ExpenseRepository extends CrudRepository<Expense,Integer>{
    
    public List<Expense> findByUser(AppUser user);
}
