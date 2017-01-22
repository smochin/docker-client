package com.smochin.docker.exception;

import javax.ws.rs.WebApplicationException;

public class ConflictException extends WebApplicationException {
	
	public ConflictException() {
		super("conflict");
	}
	
}
