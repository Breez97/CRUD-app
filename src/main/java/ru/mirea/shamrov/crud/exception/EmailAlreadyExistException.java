package ru.mirea.shamrov.crud.exception;

public class EmailAlreadyExistException extends RuntimeException {

	public EmailAlreadyExistException(String message) {
		super(message);
	}

}
