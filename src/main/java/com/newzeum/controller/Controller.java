package com.newzeum.controller;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newzeum.database.DatabaseManager;
import com.newzeum.dto.MuseumDTO;
import com.newzeum.dto.MuseumItemDTO;

public class Controller {

	private static Controller instance;
	private DatabaseManager dbManager;
	
	private Controller(){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			dbManager = new DatabaseManager();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Controller getInstance(){
		if (instance == null){
			instance = new Controller();
		}
		return instance;
	}
	
	public List<MuseumDTO> getMuseumList(){
		List<MuseumDTO> museumList = new ArrayList<MuseumDTO>();
	
		try {
			museumList = dbManager.getMuseumList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return museumList;
	}
	
	public MuseumDTO getMuseumInfo(Integer id) {
		MuseumDTO museum = new MuseumDTO();
		
		try {
			museum = dbManager.getMuseumInfo(id);
			museum.setItems(dbManager.getMuseumItemsForMuseum(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return museum;
		
	}
	
	public MuseumItemDTO getItemInfo(Integer id, Integer museumId){
		MuseumItemDTO museumItem = new MuseumItemDTO();
		
		try {
			museumItem = dbManager.getItemInfo(id, museumId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return museumItem;
		
	}
	
}
