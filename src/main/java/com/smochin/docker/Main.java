/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smochin.docker;

import com.smochin.common.rest.client.Rest;
import com.smochin.common.rest.client.callable.Callable;
import com.smochin.common.rest.client.callable.Get;
import com.smochin.common.rest.client.callable.Post;
import com.smochin.common.rest.client.response.HttpResponse;

/**
 *
 * @author mion
 */
public class Main {
    public static void main(String[] args) {
        Rest rest = new Rest("sadasd");
        
        Callable<Get> get = rest.get("asd");
        
        Callable<Post> pc = rest.post("asd");
        pc.chunkHandler(ch -> {
        
        });
        
        get.chunkHandler(ch -> {
            
        });
        
        HttpResponse r1 = pc.call();
        
        
        
        HttpResponse r = get.call();
    }
}
