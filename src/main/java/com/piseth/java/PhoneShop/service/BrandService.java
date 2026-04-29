package com.piseth.java.PhoneShop.service;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;

import java.util.Optional;

public interface BrandService {
	BrandDTO create(Brand brand);
    BrandDTO getById(Integer id);
}
