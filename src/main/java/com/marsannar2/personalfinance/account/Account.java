package com.marsannar2.personalfinance.account;

import com.marsannar2.personalfinance.models.BaseEntity;
import com.marsannar2.personalfinance.user.User;

import jakarta.persistence.CascadeType;
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
@Table(name="accounts")
public class Account extends BaseEntity{
    
    @Column(name="quantity",precision=2,nullable=false)
    private Double quantity;

    @Column(name="account_type",nullable=false)
    private AccountType type;

    @Column(name="connection")
    private String connection;

    @JoinColumn(name="user_id",referencedColumnName = "id",nullable=false)
    @ManyToOne(optional=false)
    private User user;
}
