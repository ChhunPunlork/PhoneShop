package com.piseth.java.PhoneShop.service;

import java.util.List;

import com.piseth.java.PhoneShop.Entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer update, Brand brandToUpdate);
	List<Brand> getBrands();
	List<Brand> getBrands(String brand);
	
	
}
