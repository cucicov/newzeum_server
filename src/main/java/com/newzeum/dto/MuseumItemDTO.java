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
