package com.MysqlCRUDUsingSpring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MysqlCRUDUsingSpring.model.users;


public interface usersRepository extends JpaRepository <users, Integer> {

	
}
