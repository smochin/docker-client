package com.smochin.docker.endpoint;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.ServerErrorException;

import com.smochin.common.rest.client.Rest;
import com.smochin.common.rest.client.callable.Callable;
import com.smochin.common.rest.client.callable.Delete;
import com.smochin.common.rest.client.callable.Get;
import com.smochin.common.rest.client.callable.Post;
import com.smochin.common.rest.client.callable.handler.ChunkHandler;
import com.smochin.common.rest.client.response.HttpResponse;
import com.smochin.docker.exception.BadParameterException;
import com.smochin.docker.exception.ConflictException;
import com.smochin.docker.exception.NoSuchImageException;
import com.smochin.docker.exception.RepositoryNotFoundException;

public class ImagesString extends Rest implements Images<HttpResponse>{
    
    public ImagesString(String url) {
        super(url);
    }
    
    //200, 500
    @Override
    public final HttpResponse list() throws ServerErrorException {
        Get get = get("/images/json");
        return get.call();
    }
    
    /*
    200 – no error
	 500 – server error
    */
    @Override
    public final HttpResponse build() throws ServerErrorException, Exception {
    	Callable<Post> callable = builds();
        return callable.call();
    }
    
    /*
     200 – no error
	 500 – server error
     */
    @Override
    public HttpResponse build(ChunkHandler chunkHandler) throws ServerErrorException, Exception {
    	Callable<Post> callable = builds();
    	callable.chunkHandler(chunkHandler);
    	return callable.call();
    }
    
    private Callable<Post> builds() {
    	Callable<Post> callable = post("/v1.24/build");
    	return callable;
    }
    
    /*
     * 200 – no error
	 * 404 - repository does not exist or no read access
	 * 500 – server error
     */
    @Override
    public HttpResponse create(String fromImage) throws RepositoryNotFoundException, ServerErrorException, Exception {
        Callable<Post> post = createFromImage(fromImage);
        return post.call();
    }
    
    /*
     * 200 – no error
	 * 404 - repository does not exist or no read access
	 * 500 – server error
     */
    @Override
    public HttpResponse create(String fromImage, ChunkHandler chunkHandler) throws ServerErrorException, NotFoundException, Exception {
        Callable<Post> create = createFromImage(fromImage);
        create.chunkHandler(chunkHandler);
        return create.call();
    }
    
    private Callable<Post> createFromImage(String image) {
        Callable<Post> post = post("/images/create");
        post.query("fromImage", image);
        return post;
    }
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 500 – server error
     */
    @Override
    public HttpResponse inspect(String name) throws NoSuchImageException, ServerErrorException, Exception {
        String path = String.format("/images/%s/json", name);
        Callable<Get> get = get(path);
        return get.call();
    }
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 500 – server error
     */
    @Override
    public HttpResponse history(String name) throws NoSuchImageException, ServerErrorException, Exception {
        String path = String.format("/images/%s/history", name);
        Callable<Get> get = get(path);
        return get.call();
    }
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 500 – server error
     */
    @Override
    public HttpResponse push(String name, ChunkHandler chunkHandler) throws NoSuchImageException, ServerErrorException, Exception {
        String path = String.format("/images/%s/push", name);
        Callable<Post> push = post(path);
        push.chunkHandler(chunkHandler);
        return push.call();
    }
    
    /*
     * 201 – no error
     * 400 – bad parameter
     * 404 – no such image
     * 409 – conflict
     * 500 – server error
    */
    @Override
    public HttpResponse tag(String name, String repo, String tag) throws BadParameterException, NoSuchImageException, ConflictException, ServerErrorException, Exception  {
        String path = String.format("/images/%s/push", name);
        Callable<Post> post = post("/images/");
        post.query("repo", repo);
        post.query("tag", tag);
        
        return post.call();
    }
    
    /*
     * 200 – no error
	 * 404 – no such image
	 * 409 – conflict
	 * 500 – server error
     */
    @Override
    public HttpResponse remove(String name) throws NoSuchImageException, ConflictException, ServerErrorException, Exception {
        String path = String.format("/images/%s", name, name);
        Callable<Delete> delete = delete(path);
        return delete.call();
    }
    
    /*
     * 200 – no error
	 * 500 – server error
     */
    @Override
    public HttpResponse search(String type, String query) throws ServerErrorException, Exception {
        Callable<Get> search = get("/images/search");
        search.query(type, query);
        return search.call();
    }
}
