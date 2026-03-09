package com.ashish.store_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ashish.store_jpa.entities.Address;
import com.ashish.store_jpa.entities.Profile;
import com.ashish.store_jpa.entities.Tag;
import com.ashish.store_jpa.entities.User;

@SpringBootApplication
public class StoreJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreJpaApplication.class, args);

		System.out.println("java is easy to learn");

		var user = new User();
		user.setName("sai ashish");
		user.setEmail("saiashish@gmail.com");
		user.setPassword("password");

		var address = new Address();
		address.setCity("city");
		address.setStreet("street");
		address.setZip("zip");

		user.addAddress(address);

		var tag = new Tag();
		tag.setName("some tag");

		user.addTags(tag);

		System.out.println(user);

		Profile profile = new Profile();
		profile.setBio("bio");

		user.addProfile(profile);
		System.out.println(user);

		context.close();
	}

}
