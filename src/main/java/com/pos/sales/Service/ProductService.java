package com.pos.sales.Service;

import com.pos.sales.Dao.ProductRepository;
import com.pos.sales.Entities.Brand;
import com.pos.sales.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

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
        Brand brand = product.getBrand();
        brand = this.brandService.findByBrandAndCategory(brand.getBrandName(), brand.getCategory());
        product.setBrand(brand);
        if (brand != null){
            this.productRepository.save(product);
            return "Product added successfully";
        }
        else{
            return "Some error occurred / No such brand exists";
        }
    }

    public void addProductList(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = reader.readLine()) != null){
                String[] columns = line.split(",");
                String barcode = columns[0];
                String productName = columns[1];
                double mrp = Double.parseDouble(columns[2]);
                String brandName = columns[3];
                String category = columns[4];
//                barcode, product, mrp, brand, category --> order of the column
                Brand brand = new Brand(brandName, category);
                Product product = new Product();
                product.setName(productName);
                product.setBarcode(barcode);
                product.setMrp(mrp);
                product.setBrand(brand);
                this.addProduct(product);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Product updateProduct(int productId, Product newProduct){
        System.out.println("new Product : "+ newProduct);
        System.out.println("product id is : " + productId);
        Optional<Product> optionalProduct = this.productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product oldProduct = optionalProduct.get();
            newProduct.setId(oldProduct.getId());
            Brand brand = this.brandService.findByBrandAndCategory(newProduct.getBrand().getBrandName(), newProduct.getBrand().getCategory());
            if (brand != null) {
                newProduct.setBrand(brand);
            }
            return this.productRepository.save(newProduct);
        }
        return null;
    }
}
