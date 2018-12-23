package com.ilse.springBootMySql.domain.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository  extends CrudRepository<User, Integer> {

    public Optional<User> findByName(String name);

}

