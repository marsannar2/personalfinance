package com.marsannar2.personalfinance.transaction;

import com.marsannar2.personalfinance.account.Account;
import com.marsannar2.personalfinance.models.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="transactions")
public class Transaction extends BaseEntity{
    
    @Column(nullable=false,precision = 2)
    private Double quantity;

    @Column(nullable=false)
    private MoneyFlow money_flow;

    @Column(nullable=false,length=128)
    @NotBlank
    private String description;

    @JoinColumn(name="user_id",referencedColumnName = "id",nullable=false)
    @ManyToOne(optional=false)
    private Account account;


}
