package com.newzeum.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MuseumListDTO implements Serializable {

	private static final long serialVersionUID = 39073302399208732L;
	List<MuseumDTO> museumList = new ArrayList<MuseumDTO>();
	
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
	public List<MuseumDTO> getMuseumList() {
		return museumList;
	}
	public void setMuseumList(List<MuseumDTO> museumList) {
		this.museumList = museumList;
	}
	
}
