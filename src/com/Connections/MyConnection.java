package com.Connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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
	
	public void conectar()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ImpossibleIntegrals","root","");
		}
		catch(SQLException | ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "error al conectar "+e.getMessage());
		}
	}
	
	public void desconectar()
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
			JOptionPane.showMessageDialog(null, "error al desconectar "+e.getMessage());
		}
	}

}
