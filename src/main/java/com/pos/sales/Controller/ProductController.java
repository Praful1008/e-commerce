package com.pos.sales.Controller;


import com.pos.sales.Entities.Product;
import com.pos.sales.Service.ProductService;
import org.hibernate.engine.jdbc.ReaderInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping("/products/file")
    public void addProductList(@RequestParam MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            this.productService.addProductList(inputStream);
        }
        catch (Exception e){
            System.out.println("some error occurred!");
        }
    }

    @PutMapping("/product/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product){
        this.productService.updateProduct(productId, product);
        return null;
    }
}
