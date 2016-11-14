package com.smochin.docker.endpoint;

import java.util.Map;

import com.smochin.common.rest.client.Rest;
import com.smochin.common.rest.client.callable.Callable;
import com.smochin.common.rest.client.callable.Delete;
import com.smochin.common.rest.client.callable.Get;
import com.smochin.common.rest.client.callable.Post;
import com.smochin.common.rest.client.callable.Put;
import com.smochin.common.rest.client.response.HttpResponse;

public class Containers extends Rest {
	
	public Containers(String url) {
		super(url);
	}

	/*
	 200 – no error
	 400 – bad parameter
	 500 – server error
	 */
	public final HttpResponse list() {
        return list(null);
    }
	
	/*
	 200 – no error
	 400 – bad parameter
	 500 – server error
	 */
	public final HttpResponse list(Map queryMap) {
        Get get = get("/containers/json");
        return get.call();
    }
	
	/*
	201 – no error
	400 – bad parameter
	404 – no such container
	406 – impossible to attach (container not running)
	409 – conflict
	500 – server error
	 */
	public HttpResponse create() {
        Callable<Post> post = post("/containers/create");
        return post.call();
    }
	
	/*
	 200 – no error
	 404 – no such container
	 500 – server error
	 */
	public HttpResponse inspect(String idOrName) {
        Callable<Get> post = get("/containers/{id or name}/json");
        return post.call();
    }
	/*
	200 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse top(String idOrName) {
        Callable<Get> post = get("/containers/{id or name}/top");
        return post.call();
    }
	
	/*
	 101 – no error, hints proxy about hijacking
 	 200 – no error, no upgrade header found
	 404 – no such container
	 500 – server error
	 */
	public HttpResponse logs(String idOrName) {
        Callable<Get> post = get("/containers/{id or name}/logs");
        return post.call();
    }
	
	/*
	200 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse changes(String idOrName) {
        Callable<Get> post = get("/containers/{id or name}/changes");
        return post.call();
    }
	
	/*
	200 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse export(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/export");
        return post.call();
    }
	
	
	/*
	200 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse stats(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/stats");
        return post.call();
    }
	
	/*
	200 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse resize(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/resize");
        return post.call();
    }
	
	/*
	204 – no error
	304 – container already started
	404 – no such container
	500 – server error
	*/
	public HttpResponse start(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/start");
        return post.call();
    }
	
	/*
	204 – no error
	304 – container already started
	404 – no such container
	500 – server error
	*/
	public HttpResponse stop(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/stop");
        return post.call();
    }
	
	/*
	204 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse restart(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/restart");
        return post.call();
    }
	
	/*
	204 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse kill(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/kill");
        return post.call();
    }
	
	/*
	200 – no error
	400 – bad parameter
	404 – no such container
	500 – server error
	*/
	public HttpResponse update(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/update");
        return post.call();
    }
	
	/*
	204 – no error
	404 – no such container
	409 - conflict name already assigned
	500 – server error
	*/
	public HttpResponse rename(String idOrName, String newName) {
        Callable<Post> post = post("/containers/(id or name)/rename");
        return post.call();
    }
	
	/*
	204 – no error
	404 – no such container
	500 – server error
	/*/
	public HttpResponse pause(String idOrName) {
        Callable<Post> post = post("/containers/(id or name)/pause");
        return post.call();
    }
	
	/*
	204 – no error
	404 – no such container
	500 – server error
	/*/
	public HttpResponse unpause(String idOrName) {
        Callable<Post> post = post("/containers/(id or name)/unpause");
        return post.call();
    }
	
	/*
	101 – no error, hints proxy about hijacking
	200 – no error, no upgrade header found
	400 – bad parameter
	404 – no such container
	409 - container is paused
	500 – server error
	*/
	public HttpResponse attach(String idOrName) {
        Callable<Post> post = post("/containers/(id or name)/attach");
        return post.call();
    }
	
	/*
	200 – no error
	400 – bad parameter
	404 – no such container
	500 – server error
	*/
	public HttpResponse attachWS(String idOrName) {
        Callable<Post> post = post("/containers/(id or name)/attach/ws");
        return post.call();
    }
	
	/*
	200 – no error
	404 – no such container
	500 – server error
	*/
	public HttpResponse wait(String idOrName) {
        Callable<Post> post = post("/containers/(id or name)/wait");
        return post.call();
    }
	
	/*
	204 – no error
	400 – bad parameter
	404 – no such container
	409 – conflict
	500 – server error
	*/
	public HttpResponse remove(String idOrName) {
        Callable<Delete> post = delete("/containers/(id or name)");
        return post.call();
    }
	
	/*
	200 - success, returns archive of copied resource
	400 - client error, bad parameter, details in JSON response body, one of:
	must specify path parameter (path cannot be empty)
	not a directory (path was asserted to be a directory but exists as a file)
	404 - client error, resource not found, one of: – no such container (container id does not exist)
	no such file or directory (path does not exist)
	500 - server error
	*/
	public HttpResponse archive(String idOrName) {
        Callable<Get> post = get("/containers/(id or name)/archive");
        return post.call();
    }
	
	/*
	200 – the content was extracted successfully
	400 - client error, bad parameter, details in JSON response body, one of:
	must specify path parameter (path cannot be empty)
	not a directory (path should be a directory but exists as a file)
	unable to overwrite existing directory with non-directory (if noOverwriteDirNonDir)
	unable to overwrite existing non-directory with directory (if noOverwriteDirNonDir)
	403 - client error, permission denied, the volume or container rootfs is marked as read-only.
	404 - client error, resource not found, one of: – no such container (container id does not exist)
	no such file or directory (path resource does not exist)
	500 – server error
	*/
	public HttpResponse extractArchive(String idOrName) {
        Callable<Put> post = put("/containers/(id or name)/archive");
        return post.call();
    }
	
	
}
