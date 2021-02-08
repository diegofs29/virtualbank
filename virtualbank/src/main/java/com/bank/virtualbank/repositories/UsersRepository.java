package com.bank.virtualbank.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bank.virtualbank.entities.User;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

}
