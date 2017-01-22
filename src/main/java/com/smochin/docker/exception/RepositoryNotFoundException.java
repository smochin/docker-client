package com.smochin.docker.exception;

import javax.ws.rs.WebApplicationException;

public class RepositoryNotFoundException extends WebApplicationException {
	
	public RepositoryNotFoundException() {
		super("repository does not exist or no read access");
	}
	
}
