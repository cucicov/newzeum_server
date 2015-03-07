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

public class TestDB {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newzeum?user=root&password=");
//		List<MuseumDTO> museumList = new ArrayList<MuseumDTO>();
//		
		Statement stmt = conn.createStatement();
//		
		
		String sql = "SELECT id, museum_id, name, description, img_url, audio_url FROM museum_items WHERE id = 2001 and museum_id=1000;";
		 ResultSet rs = stmt.executeQuery(sql);
		 rs.next();
		 MuseumItemDTO museumItem = new MuseumItemDTO();
		 museumItem.setId(rs.getInt("id"));
		 museumItem.setMuseumId(rs.getInt("museum_id"));
		 museumItem.setName(rs.getString("name"));
		 museumItem.setDescription(rs.getString("description"));
		 museumItem.setDescription(rs.getString("img_url"));
		 museumItem.setDescription(rs.getString("audio_url"));
		 rs.close();
		
		System.out.println(museumItem.getName());

	}

}
