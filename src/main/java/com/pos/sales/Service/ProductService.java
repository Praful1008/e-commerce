package com.pos.sales.Service;

import com.pos.sales.Dao.ProductRepository;
import com.pos.sales.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public String addProduct(Product product){
        this.productRepository.save(product);
        return "Product added successfully";
    }

}
