package com.piseth.java.PhoneShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;
import com.piseth.java.PhoneShop.Entity.Model;
import com.piseth.java.PhoneShop.mapper.Mapper;
import com.piseth.java.PhoneShop.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO dto) {
		Brand brand = Mapper.toBrand2(dto);
		brandService.create(brand);
		return ResponseEntity.ok(brand);
	}
	
}
