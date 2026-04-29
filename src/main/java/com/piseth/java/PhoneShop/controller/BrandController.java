package com.piseth.java.PhoneShop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;
import com.piseth.java.PhoneShop.Entity.Model;
import com.piseth.java.PhoneShop.mapper.Mapper;
import com.piseth.java.PhoneShop.service.BrandService;

@RestController
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

	private final BrandService brandService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody BrandDTO dto) {
		Brand brand = Mapper.toBrand2(dto);
		brandService.create(brand);
		return ResponseEntity.ok(brand);
	}

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        BrandDTO brandDTO = brandService.getById(id);
        return ResponseEntity.ok(brandDTO);
    }

	
}
