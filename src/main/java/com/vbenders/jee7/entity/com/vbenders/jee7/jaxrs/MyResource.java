package com.vbenders.jee7.entity.com.vbenders.jee7.jaxrs;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @Path("/upload")
    @POST
    @Consumes("multipart/form-data")
    public void uploadFile(MultipartFormDataInput input){
        System.err.println(">>>> sit back - starting file upload...");

    }

}
