package com.learn.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.account.dto.AccountDto;
import com.learn.account.entity.Accounts;
import com.learn.account.entity.Customer;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long>{

	Optional<Accounts> findByMobileNumber(String mobileNumber);

	Optional<Accounts> findByCustomerId(Long customerId);

	Optional<Accounts> findByAcNumber(Long accountNumber);
	

}
