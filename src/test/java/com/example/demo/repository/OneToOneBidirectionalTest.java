package com.example.demo.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.Address;
import com.example.demo.dao.Order;

@SpringBootTest
public class OneToOneBidirectionalTest {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Autowired
	private AddressRepository addressRepository;

	
	@Test
	public void saveOrder() {
		Address address = new Address();
		address.setStreet("street");
		address.setCity("city");
		address.setState("state");
		address.setCountry("country");
		address.setPincode("pincode");
		
		Order order = new Order();
		order.setOrderNumber("100ABC");
		order.setTotalQuantity(2);
		order.setTotalPrice(new BigDecimal(1000));
		order.setStatus("in-progress");
		order.setAddress(address);
		
		orderRepository.save(order);
	}	
	
	
	@Test
	public void saveAddress() {
		Address address = new Address();
		address.setStreet("street");
		address.setCity("city");
		address.setState("state");
		address.setCountry("country");
		address.setPincode("pincode");
		
		Order order = new Order();
		order.setOrderNumber("100ABC");
		order.setTotalQuantity(2);
		order.setTotalPrice(new BigDecimal(1000));
		order.setStatus("in-progress");
		order.setAddress(address);
		
		address.setOrder(order);
		
		addressRepository.save(address);
	}	
	
	
	@Test
	public void updateOrder() {
		Order order = orderRepository.findById(2L).get();
		order.setStatus("completed");
		order.getAddress().setPincode("pincode1");
		
		orderRepository.save(order);
	}
	
	
	@Test
	public void deleteOrder() {
		orderRepository.deleteById(2L);
	}
	
	
	@Test
	public void getOrder() {
		Order order = orderRepository.findById(3L).get();
		System.out.println(order.getAddress().getCity());
	}
	
	
	@Test
	public void getAddress() {
		Address address = addressRepository.findById(3L).get();
		System.out.println(address.getOrder().getId());
	}
	
}
