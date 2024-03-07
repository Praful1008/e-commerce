package com.pos.sales.Controller;


import com.pos.sales.Entities.Brand;
import com.pos.sales.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/brands")
    public List<Brand> getBrands() {
        return this.brandService.getBrands();
    }

    @PostMapping("/brands")
    public Brand addBrand(@RequestBody Brand brand) {
        return this.brandService.addBrand(brand);
    }

    @PostMapping("/brands/file")
    public ResponseEntity<String> addBrandList(@RequestParam MultipartFile file)
    {
        try {
            InputStream inputStream = file.getInputStream();
            this.brandService.addBrandList(inputStream);
            return ResponseEntity.ok("File uploaded successfully");
        }
        catch (Exception e){
            return ResponseEntity.ok("Unable to process file");
        }
    }

    @GetMapping("/brands/brandname")
    public List<Brand> getAllByBrandName(){
        return this.brandService.findAllByBrandName("Veena");
    }

    @GetMapping("/brands/brand_category")
    public Brand getByBrandAndCategory(){
        return this.brandService.findByBrandAndCategory("Pratik", "Industrialist");
    }
}
