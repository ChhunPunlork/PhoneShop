package com.piseth.java.PhoneShop.serviceImpl;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.piseth.java.PhoneShop.Entity.Brand;
import com.piseth.java.PhoneShop.exceptoin.ApiException;
import com.piseth.java.PhoneShop.exceptoin.ResourceNotFounException;
import com.piseth.java.PhoneShop.repository.BrandRepository;
import com.piseth.java.PhoneShop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandRepository brandRepository;

	@Override
	public Brand create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
//		
		return brandRepository.findById(id)
//				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, String.format("Brand with id = %d not found", id)))
				.orElseThrow(() -> new ResourceNotFounException("Brand", id));
	}

	@Override
	public Brand update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName());// @TODO improve update
		return brandRepository.save(brand);
	}

}
