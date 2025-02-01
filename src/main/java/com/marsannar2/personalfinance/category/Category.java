package com.marsannar2.personalfinance.category;

import com.marsannar2.personalfinance.models.BaseEntity;
import com.marsannar2.personalfinance.user.AppUser;

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
@Table(name="categories")
public class Category extends BaseEntity{

    @Column(name="category",nullable=false,unique=true)
    private String name;

    @JoinColumn(name="user_id",referencedColumnName = "id",nullable=false)
    @ManyToOne(optional=false)
    private AppUser user;
    
}
