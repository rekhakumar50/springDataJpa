package com.example.demo.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "addresses")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String street;
	private String city;
	private String state;
	private String country;
	private String pincode;
	
	//to do bidirectional we much have cascadeType in this property
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
	private Order order;

}
