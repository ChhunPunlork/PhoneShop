package com.piseth.java.PhoneShop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;

@Mapper
public interface BrandMapper {

//	@Mapping(target =  "version", source = "vs")

	BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

	Brand toBrand(BrandDTO dto);

	BrandDTO toBrandDTO(Brand brand);

}
