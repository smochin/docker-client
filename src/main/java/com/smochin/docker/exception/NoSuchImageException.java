package com.smochin.docker.exception;

import javax.ws.rs.WebApplicationException;

public class NoSuchImageException extends WebApplicationException {
	
	public NoSuchImageException(String string) {
		super("No such image");
	}
}
