package com.learn.account.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer",description = "Schema to hold Customer And Account Information")
public class CustomerDto {

	@Schema(description = "Name Of The Customer",example = "Sachin")
	@NotEmpty(message = "Name Cannot Be Empty or Null Value")
	@Size(min = 5,max = 30,message = "The Length Name Should be Between 5 to 30")
	private String acName;
	@Schema(description = "Email Of The Customer",example = "abc@gmail.com")
	@NotEmpty(message = "Email Address Cannot Be Empty or Null Value")
	@Email(message = "Email Address should be a valid value")
	private String email;
	@Schema(description = "Mobile Numbre Of The Customer",example = "2549548624")
	@Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
	private String mobileNumber;
	@Schema(description = "Account Details Of The Customer")
	private AccountDto accountDto;
}
