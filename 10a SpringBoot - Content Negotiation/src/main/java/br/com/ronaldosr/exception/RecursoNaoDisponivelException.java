package br.com.ronaldosr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNaoDisponivelException extends RuntimeException{

	private static final long serialVersionUID = -3553259898803702194L;

	public RecursoNaoDisponivelException(String exception) {
		super(exception);
	}
}
