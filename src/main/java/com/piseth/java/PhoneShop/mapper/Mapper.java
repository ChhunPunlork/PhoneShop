package com.piseth.java.PhoneShop.mapper;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;

public class Mapper {
//	public static Brand toBrand(BrandDTO dto) {
//		Brand brand = new Brand();
//		brand.setId(dto.getId());
//		brand.setName(dto.getName());
//		return brand;
//	}
	public static Brand toBrand2(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setName(dto.getName());
		return brand;
	}
}
