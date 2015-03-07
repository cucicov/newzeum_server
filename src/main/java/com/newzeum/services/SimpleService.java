package com.newzeum.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

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

import com.newzeum.controller.Controller;
import com.newzeum.dto.MuseumDTO;
import com.newzeum.dto.MuseumItemDTO;

@Path("/")
public class SimpleService {
 
//	@GET
//	@Path("/getMsg")
//	public Response getMsg(@QueryParam("param") String msg) {
// 
//		String output = "Jersey say : " + msg;
// 
//		return Response.status(200).entity(output).build();
// 
//	}
	
	@GET
	@Path("/getMuseumList")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMuseumList() {
		
		JSONArray arrayResponse = new JSONArray();
		
		Controller controllerInstance = Controller.getInstance();
		List<MuseumDTO> availableMuseums = controllerInstance.getMuseumList();
		for (int i = 0; i < availableMuseums.size(); i++) {
			JSONObject object = new JSONObject();
			MuseumDTO museum = availableMuseums.get(i);
			try {
				object.put("itemId", museum.getId());
				object.put("itemName", museum.getName());
				object.put("itemImageURL", museum.getImageUrl());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			arrayResponse.put(object);
		}
 
		return Response.ok(arrayResponse).build();
 
	}
	
	@GET
	@Path("/getMuseumInfo")
	public Response getMuseumInfo(@QueryParam("id") String museumId) {
 
		Controller controllerInstance = Controller.getInstance();
		
		MuseumDTO museum = controllerInstance.getMuseumInfo(Integer.parseInt(museumId));
 
		return Response.ok(museum).build();
 
	}
	
	@GET
	@Path("/getItemInfo")
	public MuseumItemDTO getItemInfo(@QueryParam("id") String itemId, 
								@QueryParam("museumId") String museumId) {
 
		Controller controllerInstance = Controller.getInstance();
		
		MuseumItemDTO museumItem = controllerInstance.getItemInfo(Integer.parseInt(itemId), Integer.parseInt(museumId));
 
		return museumItem;
 
	}
	
//	@GET
//	@Path("/getJson")
//	@Produces(MediaType.APPLICATION_JSON)
//	public TestDTO getJson() {
// 
//		TestDTO dto = new TestDTO();
//		dto.setProp("newProp");
// 
//		return dto;
// 
//	}
//	
//	@GET
//	@Path("/getJsonArray")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getJsonArray() {
// 
//		JSONArray arrayResponse = new JSONArray();
//		
//		BufferedImage img = null;
//		try {
//			ClassLoader classLoader = getClass().getClassLoader();
//			File file = new File(classLoader.getResource("images/test.jpg").getFile());
//			img = ImageIO.read(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		int elemNr = 10;
//		for (int i = 0; i < elemNr; i++) {
//			JSONObject object = new JSONObject();
//			try {
//				object.put("property", "prop"+i);
//				object.put("image", img);
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//			arrayResponse.put(object);
//		}
// 
//		return Response.ok(arrayResponse).build();
// 
//	}
 
}
