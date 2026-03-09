package com.ashish.store_jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ashish.store_jpa.entities.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

}
