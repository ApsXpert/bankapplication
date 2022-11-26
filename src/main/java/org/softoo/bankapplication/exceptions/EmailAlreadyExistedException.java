package org.softoo.bankapplication.exceptions;

public class EmailAlreadyExistedException extends RuntimeException {

	public EmailAlreadyExistedException(String message) {
		super(message);
	}
}
