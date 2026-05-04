package com.piseth.java.PhoneShop.mapper;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
	public static Brand toBrand(BrandDTO dto) {
		Brand brand = new Brand();
		brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
	}

    public static BrandDTO toBrandDTO(Brand brand) {
        BrandDTO dto = new BrandDTO();
        dto.setId(brand.getId());
        dto.setName(brand.getName());
        return dto;
    }

    public static List<BrandDTO> toListBrandDto(List<Brand> brands) {
        return brands.stream()
                .map(Mapper::toBrandDTO)
                .toList();
    }
}
