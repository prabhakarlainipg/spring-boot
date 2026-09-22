package com.example.learning.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    //Defines the foreign-key column in orders
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Order(String productName, User user) {
        this.productName = productName;
        this.user = user;
    }
}