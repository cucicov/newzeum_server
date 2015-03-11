package com.newzeum.dto;

import java.io.Serializable;
import java.util.List;

public class MuseumDTO implements Serializable {

	private static final long serialVersionUID = 7565165396962673788L;
	private Integer id; 
	private String name; 
	private String shortName; 
	private String imageUrl; 
	private String description;
	private List<MuseumItemDTO> items;
	
	private int code; // -1 unknown Error code
	private String infoMessage;
	private String errorMessage;
	
	public List<MuseumItemDTO> getItems() {
		return items;
	}
	public void setItems(List<MuseumItemDTO> items) {
		this.items = items;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCode() {
		return code;
	}

	public String getInfoMessage() {
		return infoMessage;
	}

	public void setInfoMessage(String infoMessage) {
		this.infoMessage = infoMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
