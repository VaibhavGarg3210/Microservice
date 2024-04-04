package com.learn.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.account.constant.AccountConstants;
import com.learn.account.dto.CustomerDto;
import com.learn.account.dto.ErrorResponseDto;
import com.learn.account.dto.ResponseDto;
import com.learn.account.service.AccountService;
import com.learn.account.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@Tag(name = "CRUD REST API FOR ACCOUNT BANK ", description = "CREATE,READ,UPDATE,DELETE API FOR ACCOUNT 	")
@RestController
@RequestMapping(path = "/api", produces = { MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@Validated
public class AccountsController {

	private AccountService accountService;
	private CustomerService customerService;

	@Operation(summary = "Create Account Rest Api", description = "Rest Api to create account inside bank ")
	@ApiResponse(responseCode = "201", description = "HTTP STATUS CREATED ")
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
		accountService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
	}

	@Operation(summary = "Get Account Detail Rest Api", description = "Rest Api to Get account Detail inside bank ")
	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> fetchAccount(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		System.err.println(mobileNumber);
		CustomerDto customerDto = customerService.fetchByMobileNumber(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDto);
	}

	@Operation(summary = "Update Account Rest Api", description = "Rest Api to update account inside bank ")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "HTTP STATUS CREATED "),
			@ApiResponse(responseCode = "500", description = "HTTP INTERNAL SERVICE ERROR", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))) })
	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
		boolean isUpdated = accountService.updateAccount(customerDto);
		if (isUpdated) {
			return ResponseEntity.ok().body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_UPDATE));
		}
	}

	@Operation(summary = "Delete Account Delete Rest Api", description = "Rest Api to delete account inside bank ")
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteAccount(
			@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") String mobileNumber) {
		boolean isDeleted = accountService.deleteAccount(mobileNumber);
		if (isDeleted) {
			return ResponseEntity.ok().body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_DELETE));
		}
	}
}
