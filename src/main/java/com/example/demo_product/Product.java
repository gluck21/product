package com.example.demo_product;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private Long price;
}
