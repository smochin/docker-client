package com.smochin.docker.endpoint;

import com.smochin.common.rest.client.callable.handler.ChunkHandler;
import com.smochin.common.rest.client.callable.Callable;
import com.smochin.common.rest.client.callable.Delete;
import com.smochin.common.rest.client.Rest;
import com.smochin.common.rest.client.callable.Get;
import com.smochin.common.rest.client.callable.Post;
import com.smochin.common.rest.client.response.HttpResponse;

public class Images extends Rest {
    
    public Images(String url) {
        super(url);
    }
    
    //200, 500
    public final HttpResponse list() {
        Get get = get("/images/json");
        return get.call();
    }
    
    public final String build() {
        return null;
    }
    
    public HttpResponse create(String fromImage) {
        Callable<Post> post = postFromImage(fromImage);
        return post.call();
    }
    
    public HttpResponse create(String fromImage, ChunkHandler chunkHandler) {
        Callable<Post> create = postFromImage(fromImage);
        create.chunkHandler(chunkHandler);
        return create.call();
    }
    
    private Callable postFromImage(String fromImage) {
        Callable<Post> post = post("/images/create");
        post.query("fromImage", fromImage);
        return post;
    }
    
    //200, 404, 500
    public HttpResponse inspect(String name) {
        String path = String.format("/images/%s/json", name);
        Callable<Get> get = get(path);
        return get.call();
    }
    
    //200, 404, 500
    public HttpResponse history(String name) {
        String path = String.format("/images/%s/history", name);
        Callable<Get> get = get(path);
        return get.call();
    }
    
    //200, 404, 500
    public HttpResponse push(String name, ChunkHandler chunkHandler) {
        String path = String.format("/images/%s/push", name);
        Callable<Post> push = post(path);
        push.chunkHandler(chunkHandler);
        return push.call();
    }
    
    /*
    201 – no error
    400 – bad parameter
    404 – no such image
    409 – conflict
    500 – server error
    */
    public HttpResponse tag(String name, String repo, String tag) {
        String path = String.format("/images/%s/push", name);
        Callable<Post> post = post("/images/");
        post.query("repo", repo);
        post.query("tag", tag);
        
        return post.call();
    }
    
    public HttpResponse remove(String name) {
        String path = String.format("/images/%s", name, name);
        Callable<Delete> delete = delete(path);
        return delete.call();
    }
    
    //200, 500
    public HttpResponse search(String type, String query) {
        Callable<Get> search = get("/images/search");
        search.query(type, query);
        return search.call();
    }
}
