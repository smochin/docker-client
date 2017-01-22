package com.smochin.docker.endpoint;

import javax.ws.rs.ServerErrorException;

import com.smochin.common.rest.client.callable.handler.ChunkHandler;
import com.smochin.docker.exception.BadParameterException;
import com.smochin.docker.exception.ConflictException;
import com.smochin.docker.exception.NoSuchImageException;
import com.smochin.docker.exception.RepositoryNotFoundException;

public interface Images<T> {
    
    
	/*
     * 200 – no error
	 * 500 – server error
    */
    public T list() throws ServerErrorException, Exception;
    
    /*
     * 200 – no error
	 * 500 – server error
    */
    public T build() throws ServerErrorException, Exception;
    
    /*
     200 – no error
	 500 – server error
    */
    public T build(ChunkHandler chunkHandler) throws ServerErrorException, Exception;
    
    /*
     * 200 – no error
	 * 404 - repository does not exist or no read access
	 * 500 – server error
     */
    public T create(String fromImage) throws RepositoryNotFoundException, ServerErrorException, Exception;
    
    /*
     * 200 – no error
	 * 404 - repository does not exist or no read access
	 * 500 – server error
     */
    public T create(String fromImage, ChunkHandler chunkHandler) throws RepositoryNotFoundException, ServerErrorException, Exception;
    
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 500 – server error
     */
    public T inspect(String name) throws NoSuchImageException, ServerErrorException, Exception;
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 500 – server error
     */
    public T history(String name) throws NoSuchImageException, ServerErrorException, Exception;
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 500 – server error
     */
    public T push(String name, ChunkHandler chunkHandler) throws NoSuchImageException, ServerErrorException, Exception;
    
    /*
     * 201 – no error
     * 400 – bad parameter
     * 404 – no such image
     * 409 – conflict
     * 500 – server error
    */
    public T tag(String name, String repo, String tag) throws BadParameterException, NoSuchImageException, ConflictException, ServerErrorException, Exception;
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 409 – conflict
	 * 500 – server error
     */
    public T remove(String name) throws NoSuchImageException, ConflictException, ServerErrorException, Exception;
    
    /*
     * 200 – no error
	 * 500 – server error
     */
    public T search(String type, String query) throws ServerErrorException, Exception ;
}
