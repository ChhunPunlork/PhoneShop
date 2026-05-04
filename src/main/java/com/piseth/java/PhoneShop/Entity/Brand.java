package com.piseth.java.PhoneShop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private Integer id;

	@Column(name = "brand_name")
	private String name;

}
