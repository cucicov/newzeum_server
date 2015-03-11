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
	
	private Controller() throws ClientResponseMetaInfo{
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			dbManager = new DatabaseManager();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ClientResponseMetaInfo(e.getMessage(), e.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ClientResponseMetaInfo(e.getMessage(), -1);
		}
	}
	
	public static Controller getInstance() throws ClientResponseMetaInfo{
		if (instance == null){
			instance = new Controller();
		}
		return instance;
	}
	
	public List<MuseumDTO> getMuseumList() throws ClientResponseMetaInfo{
		List<MuseumDTO> museumList = new ArrayList<MuseumDTO>();
	
		try {
			dbManager.openConnection();
			museumList = dbManager.getMuseumList();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ClientResponseMetaInfo(e.getMessage(), e.getErrorCode());
		} finally {
			try {
				dbManager.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ClientResponseMetaInfo(e.getMessage(), e.getErrorCode());
			}
		}
		
		return museumList;
	}
	
	public MuseumDTO getMuseumInfo(Integer id) throws ClientResponseMetaInfo {
		MuseumDTO museum = new MuseumDTO();
		
		try {
			dbManager.openConnection();
			museum = dbManager.getMuseumInfo(id);
			museum.setItems(dbManager.getMuseumItemsForMuseum(id));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ClientResponseMetaInfo(e.getMessage(), e.getErrorCode());
		} finally {
			try {
				dbManager.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ClientResponseMetaInfo(e.getMessage(), e.getErrorCode());
			}
		}
		
		return museum;
		
	}
	
	public MuseumItemDTO getItemInfo(Integer id, Integer museumId) throws ClientResponseMetaInfo{
		MuseumItemDTO museumItem = new MuseumItemDTO();
		
		try {
			dbManager.openConnection();
			museumItem = dbManager.getItemInfo(id, museumId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ClientResponseMetaInfo(e.getMessage(), e.getErrorCode());
		} finally {
			try {
				dbManager.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ClientResponseMetaInfo(e.getMessage(), e.getErrorCode());
			}
		}
		return museumItem;
		
	}
	
}
