package com.learn.account.service.impl;

import org.springframework.stereotype.Service;

import com.learn.account.AccountsMapper.AccountMapper;
import com.learn.account.AccountsMapper.CustomerMapper;
import com.learn.account.dto.AccountDto;
import com.learn.account.dto.CustomerDto;
import com.learn.account.entity.Accounts;
import com.learn.account.entity.Customer;
import com.learn.account.repository.AccountRepository;
import com.learn.account.repository.CustomerRepository;
import com.learn.account.service.CustomerService;
import com.learn.account.service.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	private AccountRepository  accountRepository;
	
	@Override
	public CustomerDto fetchByMobileNumber(String mobileNumber) {
		System.err.println(mobileNumber);
		Customer customer =  customerRepository.findByMobileNumber(mobileNumber). orElseThrow(
				() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
		System.err.println(customer);
		Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString() ));
		CustomerDto customerDto=  CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
		System.err.println(accounts+"-->"+accounts);
		customerDto.setAccountDto(AccountMapper.mapToAccountDto(accounts, new AccountDto()));
		return customerDto;
	}

}
