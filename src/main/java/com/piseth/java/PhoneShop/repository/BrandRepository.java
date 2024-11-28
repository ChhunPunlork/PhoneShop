package com.piseth.java.PhoneShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piseth.java.PhoneShop.Entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	List<Brand> findByNameLike(String name);
	List<Brand> findBycontaining(String name);
}
