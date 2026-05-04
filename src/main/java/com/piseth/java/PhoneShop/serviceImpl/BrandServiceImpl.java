package com.piseth.java.PhoneShop.serviceImpl;

import com.piseth.java.PhoneShop.DTO.BrandDTO;
import com.piseth.java.PhoneShop.controller.BrandController;
import com.piseth.java.PhoneShop.exception.ApiException;
import com.piseth.java.PhoneShop.exception.ErrorResponse;
import com.piseth.java.PhoneShop.exception.ResourceNotFoundException;
import com.piseth.java.PhoneShop.mapper.Mapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piseth.java.PhoneShop.Entity.Brand;
import com.piseth.java.PhoneShop.repository.BrandRepository;
import com.piseth.java.PhoneShop.service.BrandService;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;
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
        Brand brand = brandRepository
                .findById(id)
                .orElseThrow(() ->
                        new ApiException(HttpStatus.NOT_FOUND, "Brand not found")
                );
        return Mapper.toBrandDTO(brand);
    }

    @Override
    public List<BrandDTO> getAll() {
        List<Brand> brand = this.brandRepository.findAll();
        return Mapper.toListBrandDto(brand);
    }

    @Override
    public List<BrandDTO> getByName(String name) {
        List<Brand> nameToSearch = this.brandRepository.findByNameIgnoreCase(name);
        if (nameToSearch.isEmpty() || nameToSearch == null) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Brand not found");
        }
        return Mapper.toListBrandDto(nameToSearch);
    }

    @Override
    public BrandDTO updateById(Integer idToUpdate, Brand brandToUpdate) {
        Brand brand = this.brandRepository.findById(idToUpdate).orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Not found!"));
        if (brandToUpdate == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Brand data id required!");
        }
        brand.setName(brandToUpdate.getName());
        Brand brandSaved = this.brandRepository.save(brand);
        return Mapper.toBrandDTO(brandSaved);
    }

    @Override
    public List<BrandDTO> getAllByOrderByNameAsc() {
        return Mapper.toListBrandDto(this.brandRepository.findAllByOrderByNameAsc());
    }

    @Override
    public List<BrandDTO> getAllByOrderByNameDesc() {
        return Mapper.toListBrandDto(this.brandRepository.findAllByOrderByNameDesc());
    }

    @Override
    public List<BrandDTO> getAllByOrderByIdAsc() {
        return Mapper.toListBrandDto(this.brandRepository.findAllByOrderByIdAsc());
    }

    @Override
    public List<BrandDTO> getAllByOrderByIdDesc() {
        return Mapper.toListBrandDto(this.brandRepository.findAllByOrderByIdDesc());
    }

    @Override
    public List<BrandDTO> getAllByManual(String sortBy, String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(sortDirection, sortBy);
        List<Brand> brands = this.brandRepository.findAll(sort);
        return Mapper.toListBrandDto(brands);
    }

    @Override
    public Page<BrandDTO> getAll(int page, int size, String sortBy, String direction) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(sortDirection, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<BrandDTO> brandDTOPage = this.brandRepository.findAll(pageable).map(Mapper::toBrandDTO);
        return brandDTOPage;

    }

}
