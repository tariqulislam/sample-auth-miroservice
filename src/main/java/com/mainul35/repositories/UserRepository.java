package com.mainul35.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.mainul35.model.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
