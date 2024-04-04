package com.learn.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.account.entity.Accounts;
import com.learn.account.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer ,Long>{
	
	//derived Name Method
	Optional<Customer> findByMobileNumber(String mobileNo);

}
