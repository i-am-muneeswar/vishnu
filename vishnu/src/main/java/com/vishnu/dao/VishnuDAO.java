package com.vishnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vishnu.entity.VishnuUser;

public class VishnuDAO implements VishnuDAOInterface {
	
	Connection con = null;
	
	public VishnuDAO() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int createProfileDAO(VishnuUser vu) {
		
		int i = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into VishnuUser values(?,?,?,?)");
			ps.setString(1, vu.getName());
			ps.setString(2, vu.getPassword());
			ps.setString(3, vu.getEmail());
			ps.setString(4, vu.getAddress());
			
			i = ps.executeUpdate();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return i;
		
	}

	public int deleteProfileDAO(VishnuUser vu) {

		int i = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("delete from VishnuUser where email=?");
			ps.setString(1, vu.getEmail());
			
			i = ps.executeUpdate();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	public VishnuUser viewProfileDAO(VishnuUser vu) {
		
		VishnuUser v = null;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from VishnuUser where email=?");
			ps.setString(1, vu.getEmail());
			
			ResultSet res = ps.executeQuery();
			
			if(res.next()) {
				
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);	
						
				v = new VishnuUser();
				v.setName(n);
				v.setPassword(p);
				v.setEmail(e);
				v.setAddress(a);
				
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return v;
	}

	public List<VishnuUser> viewAllProfilesDAO() {

		VishnuUser v = null;
		List<VishnuUser> ll = new ArrayList<VishnuUser>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from VishnuUser");
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);		
						
				v = new VishnuUser();
				v.setName(n);
				v.setPassword(p);
				v.setEmail(e);
				v.setAddress(a);
			
				ll.add(v);
				
			}
				
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ll;
	}

	public List<VishnuUser> searchProfileDAO(VishnuUser vu) {

		VishnuUser v = null;
		List<VishnuUser> ll = new ArrayList<VishnuUser>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("select * from VishnuUser where name=?");
			ps.setString(1, vu.getName());
			
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				
				String n = res.getString(1);
				String p = res.getString(2);
				String e = res.getString(3);
				String a = res.getString(4);	
						
				v = new VishnuUser();
				v.setName(n);
				v.setPassword(p);
				v.setEmail(e);
				v.setAddress(a);
				
				ll.add(v);
				
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ll;
	}

	
	
	public int editProfileDAO(VishnuUser vu) {

		int i = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement("update VishnuUser set name=?, password=?, address=? where email=?");
			ps.setString(1, vu.getName());
			ps.setString(2, vu.getPassword());
			ps.setString(4, vu.getEmail());
			ps.setString(3, vu.getAddress());
			
			i = ps.executeUpdate();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}

		return i;
		
	}

}
