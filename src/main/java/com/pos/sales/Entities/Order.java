package com.pos.sales.Entities;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Order")
public class Order {

    @Id
    private int id;
    private int orderId;
    private int productId;
    private int quantity;
    private int SellingPrice;
}
