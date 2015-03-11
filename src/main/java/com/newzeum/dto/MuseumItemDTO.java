package com.newzeum.dto;

import java.io.Serializable;

public class MuseumItemDTO implements Serializable {

	private static final long serialVersionUID = -8217000247073516071L;

	private Integer id;
	private Integer museumId;
	private String name;
	private String description;
	private String imageUrl;
	private String audioUrl;
	
	private int code; // -1 unknown Error code
	private String infoMessage;
	private String errorMessage;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMuseumId() {
		return museumId;
	}
	public void setMuseumId(Integer museum_id) {
		this.museumId = museum_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	
	
}
