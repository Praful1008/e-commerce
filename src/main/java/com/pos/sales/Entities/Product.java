package com.pos.sales.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String barcode;
    private int brand_category_id;
    private String productName;
    private double mrp;
}
