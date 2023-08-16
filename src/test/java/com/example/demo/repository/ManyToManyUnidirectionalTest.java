package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.Role;
import com.example.demo.dao.User;

@SpringBootTest
public class ManyToManyUnidirectionalTest {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setFirstName("Rekha");
		user.setLastName("Kumar");
		user.setEmail("rekha@gmail.com");
		user.setPhoneNumber("000-00000000");
		
		Role adminRole = new Role();
		adminRole.setName("ADMIN");
		
		Role customerRole = new Role();
		customerRole.setName("CUSTOMER");
		
		user.getRoles().add(adminRole);
		user.getRoles().add(customerRole);

		userRepository.save(user);
	}

	
	@Test
	public void updateUser() {
		User user = userRepository.findById(1L).get();
		user.setEmail("rekhakumar@gmail.com");
		user.setPhoneNumber("000-999800000");
		
		Role userRole = new Role();
		userRole.setName("USER");
		
		user.getRoles().add(userRole);

		userRepository.save(user);
	}
	
	
	@Test
	public void getUser() {
		User user = userRepository.findById(1L).get();
		System.out.println(user.getEmail());
		user.getRoles().forEach(r -> System.out.println(r.getName()));
	}
	
	
	@Test
	public void deleteUser() {
		userRepository.deleteById(1L);
	}
}
