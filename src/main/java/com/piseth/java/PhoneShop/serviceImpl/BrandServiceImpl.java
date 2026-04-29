package com.piseth.java.PhoneShop.serviceImpl;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.controller.BrandController;
import com.piseth.java.PhoneShop.mapper.Mapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piseth.java.PhoneShop.Entity.Brand;
import com.piseth.java.PhoneShop.repository.BrandRepository;
import com.piseth.java.PhoneShop.service.BrandService;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data

public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public BrandDTO create(Brand brand) {
        Brand brandSaved = this.brandRepository.save(brand);
        BrandDTO dto = Mapper.toBrandDTO(brandSaved);
        return dto;
    }

    @Override
    public BrandDTO getById(Integer id) {
        Brand brand = this.brandRepository.getById(id);
        if(brand == null){
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Brand with id: {id} not found");
        }
        return Mapper.toBrandDTO(brand);
    }


}
