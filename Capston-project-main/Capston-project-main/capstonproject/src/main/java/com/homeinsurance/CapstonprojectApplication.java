package com.homeinsurance;



import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.homeinsurance.model.Address;
import com.homeinsurance.model.Buyer;
import com.homeinsurance.model.Property;
import com.homeinsurance.service.BuyerService;

@SpringBootApplication
public class CapstonprojectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CapstonprojectApplication.class, args);
	}
	@Autowired
	BuyerService buyerService;
  
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		 Address address=new Address("kokrajhar","Assam", 78330);
		 Property property1=new Property("Building","Residential",20000000,2000);
		 Property property2=new Property("Flat","Industrial",7000000,50000);
		 Set<Property>propertyList=new HashSet<>(Arrays.asList(property1,property2));
		 Buyer  buyer=new Buyer("Rajath",99999999, address,"owner","Software Developer", propertyList);
		 buyerService.add(buyer);
	}

}
