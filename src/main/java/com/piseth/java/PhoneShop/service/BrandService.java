package com.piseth.java.PhoneShop.service;

import com.piseth.java.PhoneShop.Entity.Brand;

public interface BrandService {
	Brand create(Brand brand);
	Brand getById(Integer id);
	Brand update(Integer update, Brand brandToUpdate);
}
