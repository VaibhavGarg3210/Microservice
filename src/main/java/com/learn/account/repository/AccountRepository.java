package com.learn.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.account.entity.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Customer, Long>{
	

}
