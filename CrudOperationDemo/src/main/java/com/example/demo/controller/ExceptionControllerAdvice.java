package com.example.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exceptionHandle.CustomDeepakException;

import ResponseDTO.ResponseExceptionDTO;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	
	@ExceptionHandler(CustomDeepakException.class)
	public ResponseExceptionDTO getException(CustomDeepakException customDeepakException) {
		
		return new ResponseExceptionDTO(customDeepakException.getMessageCode(),customDeepakException.getMessageDiscription());
	}

}
