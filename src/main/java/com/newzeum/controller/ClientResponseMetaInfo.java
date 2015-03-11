package com.newzeum.controller;

/**
 * @author cucicov
 * Object to contain Error messages, warnings and metaBackend info for the client.
 */
public class ClientResponseMetaInfo extends Throwable {

	private static final long serialVersionUID = -2783123544369167526L;

	private int code; // -1 unknown Error code
	private String infoMessage;
	private String errorMessage;
	
	public ClientResponseMetaInfo(String infoMessage){
		this.code = 0; // default OK code
		this.infoMessage = infoMessage;
	}
	
	public ClientResponseMetaInfo(String errorMessage, int errorCode){
		this.code = errorCode;
		this.errorMessage = errorMessage;
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
	
}
