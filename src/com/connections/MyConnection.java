package com.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	Connection con;
	
	public Connection getCon()
	{
		return this.con;
	}
	
	public void setCon(Connection con)
	{
		this.con=con;
	}
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ImpossibleIntegrals","root","");
		}
		catch(SQLException | ClassNotFoundException e)
		{
		}
	}
	
	public void disconnect()
	{
		try
		{
			if(!con.isClosed() && con!=null)
			{
				con.close();
			}
		}
		
		catch(Exception e)
		{
		}
	}

}
