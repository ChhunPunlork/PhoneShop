package com.piseth.java.PhoneShop.repository;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.java.PhoneShop.Entity.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	Optional<Brand> findById(Integer id);
    List<Brand> findByName(String name);
    List<Brand> findByNameIgnoreCase(String name);
    List<Brand> findAllByOrderByNameAsc();
    List<Brand> findAllByOrderByNameDesc();
    List<Brand> findAllByOrderByIdDesc();
    List<Brand> findAllByOrderByIdAsc();
}