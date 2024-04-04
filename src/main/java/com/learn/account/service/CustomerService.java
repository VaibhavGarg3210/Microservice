package com.learn.account.service;

import com.learn.account.dto.CustomerDto;

public interface CustomerService {

	CustomerDto fetchByMobileNumber(String mobileNumber);

}
