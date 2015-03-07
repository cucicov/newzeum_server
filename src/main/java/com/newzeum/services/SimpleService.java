package com.newzeum.services;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.newzeum.dto.TestDTO;
 
@Path("/")
public class SimpleService {
 
	@GET
	@Path("/getMsg")
	public Response getMsg(@QueryParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/getJson")
	@Produces(MediaType.APPLICATION_JSON)
	public TestDTO getJson() {
 
		TestDTO dto = new TestDTO();
		dto.setProp("newProp");
 
		return dto;
 
	}
	
	@GET
	@Path("/getJsonArray")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonArray() {
 
		JSONArray arrayResponse = new JSONArray();
		
		BufferedImage img = null;
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("images/test.jpg").getFile());
			img = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int elemNr = 10;
		for (int i = 0; i < elemNr; i++) {
			JSONObject object = new JSONObject();
			try {
				object.put("property", "prop"+i);
				object.put("image", img);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			arrayResponse.put(object);
		}
 
		return Response.ok(arrayResponse).build();
 
	}
 
}
