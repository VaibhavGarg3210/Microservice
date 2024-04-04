package com.learn.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Schema to hold successful response information",name = "Response")
public class ResponseDto {
	@Schema(description = "Status Coden in the	 Response",example = "200")
	private String status;
	@Schema(description = "Status message in the	 Response",example = "Request processed successful")
	private String message;
}
