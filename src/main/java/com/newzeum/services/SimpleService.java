package com.newzeum.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.newzeum.controller.ClientResponseMetaInfo;
import com.newzeum.controller.Controller;
import com.newzeum.dto.MuseumDTO;
import com.newzeum.dto.MuseumItemDTO;
import com.newzeum.dto.MuseumListDTO;

@Path("/")
public class SimpleService {
 
	@GET
	@Path("/getMuseumList")
	public Response getMuseumList() {
		
		MuseumListDTO arrayResponse = new MuseumListDTO();
		
		Controller controllerInstance;
		try {
			controllerInstance = Controller.getInstance();
			List<MuseumDTO> availableMuseums = controllerInstance.getMuseumList();
			arrayResponse.setMuseumList(availableMuseums);
		} catch (ClientResponseMetaInfo e) {
			arrayResponse.setCode(e.getCode());
			arrayResponse.setErrorMessage(e.getErrorMessage());
			arrayResponse.setInfoMessage(e.getInfoMessage());
			e.printStackTrace();
		}
		
		return Response.ok(arrayResponse).build();
 
	}
	
	@GET
	@Path("/getMuseumInfo")
	public Response getMuseumInfo(@QueryParam("id") String museumId) {
 
		Controller controllerInstance;
		MuseumDTO museum = new MuseumDTO();
		try {
			controllerInstance = Controller.getInstance();
			museum = controllerInstance.getMuseumInfo(Integer.parseInt(museumId));
		} catch (ClientResponseMetaInfo e) {
			museum.setCode(e.getCode());
			museum.setErrorMessage(e.getErrorMessage());
			museum.setInfoMessage(e.getInfoMessage());
			e.printStackTrace();
		}
 
		return Response.ok(museum).build();
 
	}
	
	@GET
	@Path("/getItemInfo")
	public MuseumItemDTO getItemInfo(@QueryParam("id") String itemId, 
								@QueryParam("museumId") String museumId) {
 
		Controller controllerInstance;
		MuseumItemDTO museumItem = new MuseumItemDTO();
		try {
			controllerInstance = Controller.getInstance();
			museumItem = controllerInstance.getItemInfo(Integer.parseInt(itemId), Integer.parseInt(museumId));
		} catch (ClientResponseMetaInfo e) {
			museumItem.setCode(e.getCode());
			museumItem.setErrorMessage(e.getErrorMessage());
			museumItem.setInfoMessage(e.getInfoMessage());
			e.printStackTrace();
		}
		
		return museumItem;
 
	}
 
}
