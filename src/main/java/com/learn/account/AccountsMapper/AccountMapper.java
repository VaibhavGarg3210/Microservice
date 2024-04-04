package com.learn.account.AccountsMapper;

import com.learn.account.dto.AccountDto;
import com.learn.account.entity.Accounts;

public class AccountMapper {

	public static AccountDto mapToAccountDto(Accounts accounts,AccountDto accountDto) {
		accountDto.setAccountNumber(accounts.getAcNumber());
		accountDto.setAccountType(accounts.getAcType());
		accountDto.setBranchAddress(accounts.getBranchAdd());
		return accountDto;
	}
	
	public static Accounts mapToAccounts(Accounts accounts,AccountDto accountDto) {
		accounts.setAcNumber(accountDto.getAccountNumber());
		accounts.setAcType(accountDto.getAccountType());
		accounts.setBranchAdd(accountDto.getBranchAddress());
		return accounts;
	}
}
