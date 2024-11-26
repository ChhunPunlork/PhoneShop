package com.piseth.java.PhoneShop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piseth.java.PhoneShop.Entity.Brand;
import com.piseth.java.PhoneShop.repository.BrandRepository;
import com.piseth.java.PhoneShop.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

}
