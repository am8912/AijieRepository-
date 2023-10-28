package com.scheduleTest.entity;

import javax.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "products")
public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "rating")
    private double rating;

    @Column(name = "is_available")
    private String isAvailable;

}

