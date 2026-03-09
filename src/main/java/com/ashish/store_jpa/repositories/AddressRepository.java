package com.ashish.store_jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashish.store_jpa.entities.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
