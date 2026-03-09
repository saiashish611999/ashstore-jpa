package com.ashish.store_jpa.services;

import org.springframework.stereotype.Service;

import com.ashish.store_jpa.entities.Profile;
import com.ashish.store_jpa.entities.User;
import com.ashish.store_jpa.repositories.AddressRepository;
import com.ashish.store_jpa.repositories.ProfileRepository;
import com.ashish.store_jpa.repositories.UsersRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsersService {

    UsersRepository usersRepository;
    EntityManager entityManager;
    ProfileRepository profileRepository;
    AddressRepository addressRepository;

    @Transactional
    public void showEntityStates() {
        var user = new User();
        user.setName("sai ashish");
        user.setEmail("saiashish@gmail.com");
        user.setPassword("password");

        if (entityManager.contains(user)) {
            System.out.println("persistence");
        } else {
            System.out.println("transient | detached");
        }
        usersRepository.save(user);

        if (entityManager.contains(user)) {
            System.out.println("persistence");
        } else {
            System.out.println("transient | detached");
        }

    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(1L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    @Transactional
    public void showAddresses() {
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getUser().getEmail());
    }

}
