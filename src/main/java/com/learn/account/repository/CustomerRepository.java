package com.learn.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.account.entity.Accounts;

@Repository
public interface CustomerRepository extends JpaRepository<Accounts ,Long>{
	

}
