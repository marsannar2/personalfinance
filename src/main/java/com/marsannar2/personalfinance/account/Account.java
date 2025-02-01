package com.marsannar2.personalfinance.account;

import com.marsannar2.personalfinance.models.BaseEntity;
import com.marsannar2.personalfinance.user.AppUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="accounts")
public class Account extends BaseEntity{
    
    @Column(nullable=false)
    private Double amount;

    @Column(name="account_type",nullable=false)
    @Enumerated(value= EnumType.STRING)
    private AccountType type;

    @Column(name="bank_connection")
    private String connection;

    @JoinColumn(name="user_id",referencedColumnName = "id",nullable=false)
    @ManyToOne(optional=false)
    private AppUser user;
}
