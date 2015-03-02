package com.newzeum.controller;

public class Controller {

	private static Controller instance;
	
	private Controller(){
		//Singleton
	}
	
	public static Controller getInstance(){
		if (instance == null){
			instance = new Controller();
		}
		return instance;
	}
	
}
