package com.pt.us.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pt.us.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
