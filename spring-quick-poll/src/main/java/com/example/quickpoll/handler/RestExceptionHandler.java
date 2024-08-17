package com.example.quickpoll.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.quickpoll.dto.ErrorDetail;
import com.example.quickpoll.exception.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException res,HttpServletRequest request){
		
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setTimeStamp(new Date().getTime());
		errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetail.setTitle("Resouce Not Found");
		errorDetail.setDetail(res.getMessage());
		errorDetail.setDeveloperMessage(res.getClass().getName());
		return new ResponseEntity<>(errorDetail,null,HttpStatus.NOT_FOUND);
		
	}

}
