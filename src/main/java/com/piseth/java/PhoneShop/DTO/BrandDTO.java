package com.piseth.java.PhoneShop.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class BrandDTO {
	private String name;
//	private Integer id;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
