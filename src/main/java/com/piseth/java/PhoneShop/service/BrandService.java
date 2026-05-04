package com.piseth.java.PhoneShop.service;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.Entity.Brand;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BrandService {
	BrandDTO create(Brand brand);
    BrandDTO getById(Integer id);
    List<BrandDTO> getAll();
    List<BrandDTO> getByName(String name);
    BrandDTO updateById(Integer brandIdToUpdate, Brand brand);
    //Use in JPA
    List<BrandDTO> getAllByOrderByNameAsc();
    List<BrandDTO> getAllByOrderByNameDesc();
    List<BrandDTO> getAllByOrderByIdAsc();
    List<BrandDTO> getAllByOrderByIdDesc();
    //Use sort
    List<BrandDTO> getAllByManual(String sort, String direction);
    //Use sort + pagination
    Page<BrandDTO> getAll(int page, int size, String sortBy, String direction);
    //Use specification + sort

}
