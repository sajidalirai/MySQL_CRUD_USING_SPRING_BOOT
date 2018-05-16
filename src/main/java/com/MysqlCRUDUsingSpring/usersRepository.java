package com.MysqlCRUDUsingSpring;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface usersRepository extends JpaRepository <users, Integer> {

	
}
