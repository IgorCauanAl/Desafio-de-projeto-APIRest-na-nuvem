package edu.cursodio.edu.dio.criacaoAPI_REST.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionsHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionsHandler.class);
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handle(IllegalArgumentException businessException) {
		return new ResponseEntity<>(businessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handle(NoSuchElementException notFoundException) {
		return new ResponseEntity<>("Id não encontrado", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnexpectedException(Throwable unexpectedException) {
		var message = "Erro inesperado no servidor, veja os logs";
		logger.error(message,unexpectedException);
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

}
