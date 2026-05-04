package com.piseth.java.PhoneShop.controller;

import com.piseth.java.PhoneShop.helper.ResponseApi;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		Brand brand = Mapper.toBrand(dto);
		brandService.create(brand);
		return ResponseEntity.ok(brand);
	}

    @GetMapping("/{id}")
    public ResponseEntity<ResponseApi<?>> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseApi.ok(this.brandService.getById(id)));
    }

    @GetMapping()
    public ResponseEntity<ResponseApi<?>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseApi.ok(this.brandService.getAll()));
    }

    @GetMapping("/searchByName")
    public ResponseEntity<ResponseApi<?>> getByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseApi.ok(this.brandService.getByName(name)));
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<ResponseApi<?>> updateById(@PathVariable Integer id, @RequestBody Brand brand) {
        return ResponseEntity.status(200).body(ResponseApi.ok(this.brandService.updateById(id, brand)));
    }

    @GetMapping("/orderByNameAsc")
    public ResponseEntity<ResponseApi<?>> getAllOrderByNameAsc(){
        return ResponseEntity.status(200).body(ResponseApi.ok(this.brandService.getAllByOrderByNameAsc()));
    }
    @GetMapping("/orderByNameDesc")
    public ResponseEntity<ResponseApi<?>> getAllOrderByNameDesc(){
        return ResponseEntity.status(200).body(ResponseApi.ok(this.brandService.getAllByOrderByNameDesc()));
    }

    @GetMapping("/orderByIdAsc")
    public  ResponseEntity<ResponseApi<?>> getAllOrderByidAsc(){
        return ResponseEntity.status(202).body(ResponseApi.ok(this.brandService.getAllByOrderByNameAsc()));
    }
    @GetMapping("/orderByIdDesc")
    public ResponseEntity<ResponseApi<?>> getAllOrderByIdDesc(){
        return ResponseEntity.status(202).body(ResponseApi.ok(this.brandService.getAllByOrderByNameDesc()));
    }

    @GetMapping("/sort")
    public ResponseEntity<ResponseApi<?>> sortBrand(@RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc") String direction) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseApi.ok(this.brandService.getAllByManual(sortBy, direction)));
    }

    @GetMapping("/pageSort")
    public ResponseEntity<ResponseApi<?>> sortBrand(
            @RequestParam(defaultValue = "0",  required = false) int page,
            @RequestParam(defaultValue = "5", required = false)int size,
            @RequestParam(defaultValue = "id",  required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String direction){
        return ResponseEntity.status(HttpStatus.OK).body(ResponseApi.ok(this.brandService.getAll(page, size, sortBy, direction)));
    }
}
