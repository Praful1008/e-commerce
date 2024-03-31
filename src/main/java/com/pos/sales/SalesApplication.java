package com.pos.sales;

import com.pos.sales.Entities.Brand;
import com.pos.sales.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
		BrandService bs;
	}

}
