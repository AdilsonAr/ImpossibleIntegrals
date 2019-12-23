package com.connections;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.classes.User;

public class DAOUsers extends MyConnection{
	
	private static DAOUsers dao=null;
	
	private DAOUsers()
	{
		
	}
	
	public static DAOUsers getInstance()
	{
		if(dao==null)
		{
			dao=new DAOUsers();
		}
		return dao;
	}
	
	public void add(User user)
	{
		try
		{
			this.connect();
			String sql="insert into users (userNickname,userName,e_mail,pass) values (?,?,?,?);";
			PreparedStatement prep=getCon().prepareStatement(sql);
			prep.setString(1, user.getUserNickname());
			prep.setString(2, user.getUserName());
			prep.setString(3, user.getE_mail());
			prep.setString(4, user.getPass());
			prep.executeUpdate();
		}
		
		catch(Exception e)
		{
			
		}
		
		finally
		{
			this.disconnect();
		}
	}
	
	public User prove(String userNickname,String pass)
	{
		User user=null;
		
		try
		{
			this.connect();
			ResultSet res;
			String sql ="select*from users where userNickname=? and pass=?";
			PreparedStatement prep=getCon().prepareStatement(sql);
			prep.setString(1, userNickname);
			prep.setString(2, pass);
			res =prep.executeQuery();
			if(res.next())
			{
				user=new User();
				user.setId(res.getInt(1));
				user.setUserNickname(res.getString(2));
				user.setUserName(res.getString(3));
				user.setE_mail(res.getString(4));
				user.setPass(res.getString(5));
			}
		}
		
		catch(Exception e)
		{
			
		}
		
		finally
		{
			this.disconnect();
		}
		return user;
	}
	
	public String edit(User user)
	{
		try
		{
			this.connect();
			String sql = "update users set userNickname=?,userName=?,e_mail=?,pass=? where id=?";
			PreparedStatement prep = getCon().prepareStatement(sql);
			prep.setString(1, user.getUserNickname());
			prep.setString(2, user.getUserName());
			prep.setString(3, user.getE_mail());
			prep.setString(4, user.getPass());
			prep.setInt(5, user.getId());
			prep.executeUpdate();
			return "user's information has been updated";
		}
		
		catch(Exception e)
		{
			return "a error has appeared";
		}
		
		finally
		{
			this.disconnect();
		}
	}
	
	public ArrayList<String> list(int option)
	{
		String param="";
		if(option==1)
		{
			param="e_mail";
		}
		else {
			param="userNickname";
		}
		
		ArrayList<String> list=new ArrayList();
		
		try
		{
			this.connect();
			String sql="select "+param+" from users";
			PreparedStatement prep=getCon().prepareStatement(sql);
			ResultSet res= prep.executeQuery();
			
			while(res.next())
			{
				list.add(res.getString(1));
			}
		}
		
		catch(Exception e)
		{
			
		}
		
		finally
		{
			this.disconnect();
		}
		return list;
	}
}
