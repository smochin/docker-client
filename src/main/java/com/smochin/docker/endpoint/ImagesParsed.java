package com.smochin.docker.endpoint;

import com.smochin.common.rest.client.callable.handler.ChunkHandler;
import com.smochin.docker.entity.Image;

public class ImagesParsed {

	public Image list() {
		return null;
	}

	public Image build() {
		return null;
	}

	
	public Image build(ChunkHandler chunkHandler) {
		return null;
	}

	
	public Image create(String fromImage) {
		return null;
	}

	
	public Image create(String fromImage, ChunkHandler chunkHandler) {
		return null;
	}

	
	public Image inspect(String name) {
		return null;
	}

	
	public Image history(String name) {
		return null;
	}

	
	public Image push(String name, ChunkHandler chunkHandler) {
		return null;
	}

	
	public Image tag(String name, String repo, String tag) {
		return null;
	}

	
	public Image remove(String name) {
		return null;
	}

	
	public Image search(String type, String query) 	{
		return null;
	}

}
