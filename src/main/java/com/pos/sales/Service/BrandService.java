package com.pos.sales.Service;

import com.pos.sales.Dao.BrandRepository;
import com.pos.sales.Entities.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getBrands() {
        return (List<Brand>) this.brandRepository.findAll();
    }
    public Brand addBrand(Brand brand){
        return this.brandRepository.save(brand);
    }
    public void addBrandList(InputStream inputStream){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (findByBrandAndCategory(columns[0],columns[1]) == null){
                    Brand brand = new Brand(columns[0], columns[1]);
                    this.addBrand(brand);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing TSV file", e);
        }
    }
    public Brand findByBrandAndCategory(String brandName, String Category){
        return this.brandRepository.findByBrandNameAndCategory(brandName, Category);
    }

    public List<Brand> findAllByBrandName(String brandName){
        return this.brandRepository.findAllByBrandName(brandName);
    }

    public void deleteBrand(Brand brand){
        this.brandRepository.delete(brand);
    }

    public Brand updateBrand(int brandId, Brand new_brand){
        Optional<Brand> optionalBrand = this.brandRepository.findById(brandId);
        if (optionalBrand.isPresent()) {
            Brand old_brand = optionalBrand.get();
            new_brand.setId(old_brand.getId());
            return this.brandRepository.save(new_brand);
        }
        else
            return null;
    }
}
