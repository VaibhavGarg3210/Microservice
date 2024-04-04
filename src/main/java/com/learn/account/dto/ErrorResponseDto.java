package com.learn.account.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(description = "Schema to hold error response information",name = "ErrorResponse")
@AllArgsConstructor
public class ErrorResponseDto {
	@Schema(description = "It represent the api path")
	private String description;
	@Schema(description = "Status Code Represent the Error Happened")
	private HttpStatus statusCode;
	@Schema(description = "Status Msg Represent the Error Happened")
	private String statusMsg;
	@Schema(description = "Local Date time Represent the Error Happened Time")
	private LocalDateTime localDateTime;
	
}
