package com.pos.sales.Service;

import com.pos.sales.Dao.BrandRepository;
import com.pos.sales.Dao.ProductRepository;
import com.pos.sales.Entities.Brand;
import com.pos.sales.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandService brandService;

    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public String addProduct(Product product){
        this.productRepository.save(product);
        return "Product added successfully";
    }

    public void addProductList(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] columns = line.split(",");
                String barcode = columns[0];
                String product = columns[1];
                double mrp = Double.parseDouble(columns[2]);
                String brandName = columns[3];
                String category = columns[4];
//                barcode, product, mrp, brand, category --> order of the column
                Brand brand = this.brandService.findByBrandAndCategory(brandName, category);
                System.out.println("Brand : " + brand);
                if (brand == null){
                    System.out.println(brandName + " -> No such brandName and repository exists " + brand);
                }
                else{
                    Product p = new Product();
                    p.setProductName(product);
                    p.setMrp(mrp);
                    p.setBarcode(barcode);
                    p.setBrand_category_id(brand.getId());
                    this.productRepository.save(p);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
