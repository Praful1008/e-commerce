package com.pos.sales.Controller;


import com.pos.sales.Entities.Product;
import com.pos.sales.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return this.productService.getProducts();
    }

    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        return this.productService.addProduct(product);
    }
}
