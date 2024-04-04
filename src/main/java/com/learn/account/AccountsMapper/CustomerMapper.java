package com.learn.account.AccountsMapper;

import com.learn.account.dto.CustomerDto;
import com.learn.account.entity.Customer;

public class CustomerMapper {

	public static CustomerDto mapToCustomerDto(Customer customer,CustomerDto customerDto	) {
		customerDto.setAcName(customer.getName());
		customerDto.setEmail(customer.getEmail());	
		customerDto.setMobileNumber(customer.getMobileNumber());
		return customerDto;
	}
	
	public static Customer mapToCumtomer(CustomerDto customerDto,Customer customer) {
		customer.setName(customerDto.getAcName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		return customer;
	}
}
