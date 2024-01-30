package com.example.demo.exceptionHandle;

import lombok.Data;

@Data
public class CustomDeepakException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String messageCode;;
	private String messageDiscription;

	public CustomDeepakException(String messageCode, String messageDiscription) {
		super();
		this.messageCode = messageCode;
		this.messageDiscription = messageDiscription;
	}

}
