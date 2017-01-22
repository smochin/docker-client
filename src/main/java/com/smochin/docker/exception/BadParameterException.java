package com.smochin.docker.exception;

import javax.ws.rs.WebApplicationException;

public class BadParameterException extends WebApplicationException {
	
	public BadParameterException() {
		super("bad parameter");
	}
	
}
