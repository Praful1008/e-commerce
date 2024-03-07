package com.pos.sales.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    private String brandName;
    private String category;
    public Brand(String brandName, String category){
        this.brandName = brandName;
        this.category = category;
    }
    public Brand(){

    }
}
