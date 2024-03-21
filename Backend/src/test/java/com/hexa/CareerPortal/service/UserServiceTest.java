package com.hexa.CareerPortal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.CareerPortal.dto.UserDTO;
import com.hexa.CareerPortal.repository.UserRepository;
import com.hexa.CareerPortal.serviceImpl.UserServiceImpl;


@SpringBootTest
public class UserServiceTest {
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	UserRepository userRepository;

	@Disabled
	@Test
	void saveMethodTest()
	{
		UserDTO p=new UserDTO();
		UserDTO savedProduct=userServiceImpl.createUser(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	@Disabled
	@Test
	void saveMethodUpdateTest()
	{
		Long id = 10L;
		UserDTO  existingProductOptional=userServiceImpl.findByUserId(id);
		if(existingProductOptional!=null) {
		LOGGER.log(Level.INFO, "existingProduct in db using JPA save()"+existingProductOptional);
		existingProductOptional.setEmail("itsmekunal0501@gmail.com");
		existingProductOptional.setName("Kunal");
		UserDTO savedProduct=userServiceImpl.createUser(existingProductOptional);
		LOGGER.log(Level.INFO, "ExistingProduct in db using JPA save()"+savedProduct);
		}
		else
		{
			LOGGER.log(Level.INFO, "Existingproduct in db is not present)");
		}
	}
	@Disabled
	@Test
	public void saveAll()
	{
		List<UserDTO> userDTO=new ArrayList<>();
		
		List<UserDTO> savedProductList=userServiceImpl.createUsers(userDTO);
		LOGGER.log(Level.INFO,"saved all product"+savedProductList);
	}
	@Disabled
	@Test
	void findAllMethodTest()
	{
		List<UserDTO> productList=userServiceImpl.findAll();
		LOGGER.log(Level.INFO,"Found record");
		productList.forEach((p)->{LOGGER.log(Level.INFO,"recor: "+p);});
	}
	@Disabled
	@Test
	void deleteBYIdMethodTest()
	{
		Long id=10L;
		userServiceImpl.deleteById(id);
		UserDTO opt=userServiceImpl.findByUserId(id);
		LOGGER.log(Level.INFO,"recor deleted: "+opt);
	}
	@Disabled
	@Test
	void deleteMethodTest()
	{
		Long id =11L;
		UserDTO opt=userServiceImpl.findByUserId(id);
		userServiceImpl.deleteById(id);
		if(opt!=null)
		{
			LOGGER.log(Level.INFO,"recor deleted: "+opt);
		}
		
	}
	@Disabled
	@Test
	void deleteAllMethod()
	{
		userServiceImpl.deleteAll();
	}
	@Disabled
	@Test
	void deleteAllWithSelectedTest() {
		UserDTO p1 = userServiceImpl.findByUserId(1L); // Use orElse(null) to handle the case when the entity is not found
	    UserDTO p2 = userServiceImpl.findByUserId(2L); //
	    
	    if (p1 != null && p2 != null) { // Check if both entities are found before deleting
	        userServiceImpl.deleteAll();
	        LOGGER.log(Level.INFO, "Records deleted: ");
	    } else {
	        LOGGER.log(Level.INFO, "Unable to delete records: One or both records not found");
	    }
	}
	@Disabled
	@Test
	void existByIdMethodTest()
	{
		boolean existStatus=userRepository.existsById((long)2);
		LOGGER.log(Level.INFO, "Record found" +existStatus);
	}
	@Disabled
	@Test
	void countMethodTest()
	{
		Long count=userServiceImpl.count();
		LOGGER.log(Level.INFO, "Number of recors: " +count);
	}
	@Disabled
	@Test
	void saveMethod2Test()
	{
		UserDTO p=new UserDTO();
		UserDTO savedProduct=userServiceImpl.createUser(p);
		LOGGER.log(Level.INFO, "SavedProduct in db using JPA save()"+savedProduct);
	}

	
	
	
	

}
