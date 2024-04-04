package com.learn.account.service;

import com.learn.account.dto.AccountDto;
import com.learn.account.dto.CustomerDto;

public interface AccountService {

	/**
	 * @param customerDto
	 */
	void createAccount(CustomerDto customerDto);

	AccountDto fetchAccountDetails(String mobileNumber);
	
	boolean updateAccount(CustomerDto customerDto);
	
	boolean deleteAccount(String mobileNumber);
}
