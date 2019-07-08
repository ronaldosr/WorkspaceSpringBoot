package br.com.ronaldosr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -3553259898803702194L;

	public MyFileNotFoundException(String exception) {
		super(exception);
	}
	
	public MyFileNotFoundException(String exception, Throwable cause) {
		super(exception, cause);
	}
	
}
