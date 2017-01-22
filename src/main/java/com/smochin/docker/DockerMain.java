package com.smochin.docker;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.ServerErrorException;

import com.smochin.common.rest.client.response.HttpResponse;
import com.smochin.docker.endpoint.Images;
import com.smochin.docker.exception.BadParameterException;
import com.smochin.docker.exception.ConflictException;
import com.smochin.docker.exception.NoSuchImageException;


public class DockerMain {
    public static void main(String[] args) {
        Images images = new Images("http://localhost:2375");
        
        try {
			HttpResponse create = images.create("wordpress:4.6.0");
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (ServerErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        HttpResponse list = images.list();
        System.out.println(list.getEntity());
        
        HttpResponse inspect;
		try {
			inspect = images.inspect("wordpress:4.6.0");
			System.out.println(inspect.getEntity());
		} catch (NoSuchImageException e) {
			e.printStackTrace();
		} catch (ServerErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        HttpResponse history;
		try {
			history = images.history("wordpress:4.6.0");
			System.out.println(history.getEntity());
		} catch (NoSuchImageException e) {
			e.printStackTrace();
		} catch (ServerErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        HttpResponse tag;
		try {
			tag = images.tag("wordpress:4.6.0", "_", "tagx");
			System.out.println(tag.getEntityAsJson());
		} catch (BadParameterException e) {
			e.printStackTrace();
		} catch (NoSuchImageException e) {
			e.printStackTrace();
		} catch (ConflictException e) {
			e.printStackTrace();
		} catch (ServerErrorException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
    }
}
