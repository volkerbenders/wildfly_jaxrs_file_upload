package com.vbenders.jee7.entity.com.vbenders.jee7.jaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by mupfel on 30.03.14.
 */
@Path("/res")
public class MyResource {
    private String data;

    @GET
    public void echo(){
        System.err.println(">>>> Hello!");
    }

}
