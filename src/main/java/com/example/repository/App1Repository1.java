package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.modal.User;

public interface App1Repository1 extends CrudRepository<User, Integer> {

	Iterable<User> findAllById(int id);

}
