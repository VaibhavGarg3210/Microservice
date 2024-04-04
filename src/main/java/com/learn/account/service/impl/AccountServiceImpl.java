package com.learn.account.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.learn.account.AccountsMapper.AccountMapper;
import com.learn.account.AccountsMapper.CustomerMapper;
import com.learn.account.constant.AccountConstants;
import com.learn.account.dto.AccountDto;
import com.learn.account.dto.CustomerDto;
import com.learn.account.entity.Accounts;
import com.learn.account.entity.Customer;
import com.learn.account.repository.AccountRepository;
import com.learn.account.repository.CustomerRepository;
import com.learn.account.service.AccountService;
import com.learn.account.service.exception.CustomerAlreadyExistsException;
import com.learn.account.service.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	private CustomerRepository customerRepository;

	@Override
	public void createAccount(CustomerDto customerDto) {
		System.err.println(customerDto);
		Optional<Customer> customerOpt = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if (customerOpt.isPresent()) {
			throw new CustomerAlreadyExistsException(
					"Customer Already register with this given number " + customerDto.getMobileNumber());
		}
		Customer customer = CustomerMapper.mapToCumtomer(customerDto, new Customer());
		System.err.println(customer + customer.getCreatedBy());
		Customer savedCustomer = customerRepository.save(customer);
		accountRepository.save(createNewAccount(savedCustomer));
	}

	private Accounts createNewAccount(Customer customer) {
		Accounts newAccounts = new Accounts();
		newAccounts.setCustomerId(customer.getCustomerId());
		long randomAccountNo = 100000000L + new Random().nextInt(900000000);

		newAccounts.setAcNumber(randomAccountNo);
		newAccounts.setAcType(AccountConstants.SAVINGS);
		newAccounts.setBranchAdd(AccountConstants.ADDRESS);
		return newAccounts;
	}

	@Override
	public AccountDto fetchAccountDetails(String mobileNumber) {
		AccountDto accountDto = AccountMapper.mapToAccountDto(
				accountRepository.findByMobileNumber(mobileNumber).orElseThrow(
						() -> new ResourceNotFoundException("mobileNumber", "mobileNumber", mobileNumber.toString())),
				new AccountDto());
		return accountDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		boolean isUpdated = false;
		AccountDto accountDto = customerDto.getAccountDto();
		if (accountDto != null) {
			Accounts accounts = accountRepository.findByAcNumber(accountDto.getAccountNumber())
					.orElseThrow(() -> new ResourceNotFoundException("Account", "AccountNumber",
							accountDto.getAccountNumber().toString()));
			System.err.println(accounts+"->"+accountDto);
			AccountMapper.mapToAccounts(accounts, accountDto);
			System.err.println(accounts+"->"+accountDto);
			accounts = accountRepository.save(accounts);
			System.err.println(accounts+"->"+accountDto);
			Long customerId = accounts.getCustomerId();
			Customer customer = customerRepository.findById(customerId)
					.orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString()));
			CustomerMapper.mapToCumtomer(customerDto, customer);
			customerRepository.save(customer);
			isUpdated = true;
			return isUpdated;

		}
		return false;
	}

	@Override
	public boolean deleteAccount(String mobileNumber) {
		Customer customer = customerRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer", mobileNumber.toString()));
		accountRepository.deleteById(customer.getCustomerId());
		customerRepository.deleteById(customer.getCustomerId());
		return true	;
	}

}
