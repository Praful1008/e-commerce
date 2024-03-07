package com.pos.sales.Dao;

import com.pos.sales.Entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Brand findByBrandNameAndCategory(String name, String category);
    List<Brand> findAllByBrandName(String brandName);
}
