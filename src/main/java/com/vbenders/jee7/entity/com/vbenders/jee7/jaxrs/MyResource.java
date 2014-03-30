package com.vbenders.jee7.entity.com.vbenders.jee7.jaxrs;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by mupfel on 30.03.14.
 */
@Path("/res")
public class MyResource {
    public static final String UPLOADED_FILE_PARAMETER_NAME = "file";
    private String data;
    private static  final Logger LOGGER = LoggerFactory.getLogger(MyResource.class);
    @GET
    public void echo(){
        System.err.println(">>>> Hello!");
    }

    @Path("/upload")
    @POST
    @Consumes("multipart/form-data")
    public Response uploadFile(MultipartFormDataInput input) {
        LOGGER.info(">>>> sit back - starting file upload...");

        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
        List<InputPart> inputParts = uploadForm.get(UPLOADED_FILE_PARAMETER_NAME);

        for (InputPart inputPart : inputParts){

//            MultivaluedMap<String, String>
            MultivaluedMap<String, String> headers = inputPart.getHeaders();
            String filename = getFileName(headers);
             LOGGER.info(">>>> upload filename " + filename);
//convert the uploaded file to inputstream

            try{
                InputStream inputStream = inputPart.getBody(InputStream.class,null);


                byte [] bytes = IOUtils.toByteArray(inputStream);

                LOGGER.info(">>> File '{}' has been read, size: #{} bytes", filename, bytes.length);
                LOGGER.info("rwading ok, lets write..");
                writeFile(bytes, "/tmp/" + filename);

            } catch (IOException e) {
                e.printStackTrace();
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

        }
        return Response.status(Response.Status.OK).build();
    }

    private void writeFile(byte[] content, String filename) throws IOException {
        LOGGER.info(">>> writing #{} bytes to: {}", content.length, filename);
        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream(file);

        fop.write(content);
        fop.flush();
        fop.close();
        LOGGER.info(">>> writing complete: {}", filename);
    }

    private String getFileName(MultivaluedMap<String, String> headers) {
        String[] contentDisposition = headers.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }

}
