package com.marsannar2.personalfinance.expense;
import com.marsannar2.personalfinance.category.Category;
import com.marsannar2.personalfinance.models.BaseEntity;
import com.marsannar2.personalfinance.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="expenses")
public class Expense extends BaseEntity{
    
    @Column(nullable=false,length = 128,unique = true)
    private String name;

    @Column(nullable=false)
    private Double assigned;

    @Column(nullable=false)
    private Double target;

    @Column(name="target_is_reached",nullable=false)
    private Boolean targetIsReached;

    @JoinColumn(name="user_id",referencedColumnName = "id",nullable=false)
    @ManyToOne(optional=false)
    private User user;

    @JoinColumn(name="category_id",referencedColumnName = "id",nullable=false)
    @ManyToOne(optional=false)
    private Category category;

    

}
