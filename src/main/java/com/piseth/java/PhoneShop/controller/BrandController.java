package com.piseth.java.PhoneShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;
import com.piseth.java.PhoneShop.mapper.BrandMapper;
import com.piseth.java.PhoneShop.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody BrandDTO dto) {
		Brand brand = BrandMapper.INSTANCE.toBrand(dto);
		brand = brandService.create(brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId) {
		Brand brand = brandService.getById(brandId);

		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}

	@PutMapping("{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer brandId, @RequestBody BrandDTO brandDTO) {
		Brand brand = BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand updatedBrand = brandService.update(brandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
	}

}
