package com.smochin.docker;

import com.smochin.common.rest.client.response.HttpResponse;
import com.smochin.docker.endpoint.Images;


public class DockerMain {
    public static void main(String[] args) {
        Images images = new Images("http://localhost:2375");
        
        HttpResponse create = images.create("wordpress:4.6.0", chunk -> {
            System.out.println(chunk);
        });
        
        HttpResponse list = images.list();
        System.out.println(list.getEntity());
        
        HttpResponse inspect = images.inspect("wordpress:4.6.0");
        System.out.println(inspect.getEntity());
        
        HttpResponse history = images.history("wordpress:4.6.0");
        System.out.println(history.getEntity());
        
        HttpResponse tag = images.tag("wordpress:4.6.0", "_", "tagx");
        System.out.println(tag.getEntityAsJson());
        
    }
}
