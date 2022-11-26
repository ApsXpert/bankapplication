package org.softoo.bankapplication.advice;

import java.util.ArrayList;
import java.util.List;

import org.softoo.bankapplication.exceptions.EmailAlreadyExistedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ErrorDetails> errors = new ArrayList<ErrorDetails>();
		
		List<FieldError> errorList =  ex.getFieldErrors();
		
		for(FieldError e: errorList) {
			errors.add(new ErrorDetails(e.getField(), e.getDefaultMessage()));
		}
		
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({EmailAlreadyExistedException.class})
	public ResponseEntity<Object>  handleEmailAlreadyExistedException(RuntimeException ex, WebRequest request) {
		return new ResponseEntity<Object>(new BankError(ex.getMessage()), HttpStatus.CONFLICT);	
	}
	
	
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<Object>  handleNotHandeledException(RuntimeException ex, WebRequest request) {
		return new ResponseEntity<Object>(new BankError(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@Data
	@AllArgsConstructor
	public static class ErrorDetails {
		String field;
		String mesage;
	}
	
	@Data
	@AllArgsConstructor
	public static class BankError {
		String mesage;
	}
}
