package com.learn.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDto {

	@Schema(description = "Branch Address of Account ", example = "abc ghaziabad")
	@NotEmpty(message = "Branch Cannot Be Empty or Null Value")
	private String branchAddress;
	@Schema(description = "Account type Of The Customer", example = "Saving")
	@NotEmpty(message = "AccountType Cannot Be Empty or Null Value")
	private String accountType;
	@Schema(description = "Account Number Of The Customer", example = "5874695478")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
	private Long accountNumber;
}
