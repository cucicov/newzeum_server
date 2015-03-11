package com.newzeum.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newzeum.dto.MuseumDTO;
import com.newzeum.dto.MuseumItemDTO;

public class DatabaseManager {

	Connection conn;
	
	public DatabaseManager() throws SQLException, ClassNotFoundException{
		openConnection();
	}
	
	public List<MuseumDTO> getMuseumList() throws SQLException{
		List<MuseumDTO> museumList = new ArrayList<MuseumDTO>();
		
		Statement stmt = conn.createStatement();
		
		 String sql = "SELECT id, name, img_url, short_name FROM museums;";
		 ResultSet rs = stmt.executeQuery(sql);
		 while(rs.next()){
			 MuseumDTO museum = new MuseumDTO();
		     museum.setId(rs.getInt("id"));
		     museum.setName(rs.getString("name"));
		     museum.setImageUrl(rs.getString("img_url"));
		     museum.setShortName(rs.getString("short_name"));
		     museumList.add(museum);
		 }
		 rs.close();

		 return museumList;
	}
	
	public void openConnection() throws SQLException {
		if (conn == null || conn.isClosed()){
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newzeum?user=root&password=");
		}
	}

	public MuseumDTO getMuseumInfo(Integer id) throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newzeum?user=root&password=");
		Statement stmt = conn.createStatement();
		
		// get museum info
		 String sql = "SELECT id, name, img_url, short_name, description FROM museums WHERE id = "+String.valueOf(id);
		 ResultSet rs = stmt.executeQuery(sql);
		 rs.next();
		 MuseumDTO museum = new MuseumDTO();
		 museum.setId(rs.getInt("id"));
		 museum.setName(rs.getString("name"));
		 museum.setImageUrl(rs.getString("img_url"));
		 museum.setDescription(rs.getString("description"));
		 museum.setShortName(rs.getString("short_name"));
		 rs.close();
		 conn.close();
		 
		return museum;
	}
	
	public List<MuseumItemDTO> getMuseumItemsForMuseum(Integer museumId) throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newzeum?user=root&password=");
		Statement stmt = conn.createStatement();
		// get items for the museum
		 List<MuseumItemDTO> museumItems = new ArrayList<MuseumItemDTO>();
		 String sql = "SELECT id, museum_id, img_url FROM museum_items WHERE museum_id ="+String.valueOf(museumId);
		 ResultSet rs = stmt.executeQuery(sql);
		 while (rs.next()){
			 MuseumItemDTO museumItem = new MuseumItemDTO();
			 museumItem.setId(rs.getInt("id"));
			 museumItem.setMuseumId(rs.getInt("museum_id"));
			 museumItem.setImageUrl(rs.getString("img_url"));
			 museumItems.add(museumItem);
		 }
		 rs.close();
		 conn.close();
		 
		 return museumItems;
	}
	
	public MuseumItemDTO getItemInfo(Integer id, Integer museumId) throws SQLException{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newzeum?user=root&password=");
		Statement stmt = conn.createStatement();
		
		// get museum info
		 String sql = "SELECT id, museum_id, name, description, img_url, audio_url FROM museum_items WHERE id = "+ String.valueOf(id)+" and museum_id="+String.valueOf(museumId)+";";
		 ResultSet rs = stmt.executeQuery(sql);
		 rs.next();
		 MuseumItemDTO museumItem = new MuseumItemDTO();
		 museumItem.setId(rs.getInt("id"));
		 museumItem.setMuseumId(rs.getInt("museum_id"));
		 museumItem.setName(rs.getString("name"));
		 museumItem.setDescription(rs.getString("description"));
		 museumItem.setImageUrl(rs.getString("img_url"));
		 museumItem.setAudioUrl(rs.getString("audio_url"));
		 rs.close();
		 conn.close();
		
		return museumItem;
	}

	public void closeConnection() throws SQLException {
		 conn.close();
	}
	
}
