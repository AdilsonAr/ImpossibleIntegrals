package com.connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.classes.IntegralObject;

public class DAOIntegralObject extends MyConnection{
	
	public String add(IntegralObject integral)
	{
		try
		{
			this.conectar();
			String sql="insert into integrals values(?,?);";
			PreparedStatement prep=getCon().prepareStatement(sql);
			prep.setString(1, integral.getClassName());		
			prep.setString(2, integral.getDescription());
			
			prep.executeUpdate();
			return "Inserted";
		}
		
		catch(Exception e)
		{
			return e.getMessage();
		}
		
		finally
		{
			this.desconectar();
		}
	}
	
	public ArrayList<IntegralObject> read()
	{
		ArrayList<IntegralObject>  list=new ArrayList<IntegralObject>();
		ResultSet res;
		try
		{
			this.conectar();
			String sql="select*from integrals";
			PreparedStatement prep=getCon().prepareStatement(sql);
			res=prep.executeQuery();
			
			while(res.next())
			{
				IntegralObject integral=new IntegralObject();
				
				integral.setClassName(res.getString(1));
				integral.setDescription((res.getString(2)));
				list.add(integral);
			}
		}
		
		catch(Exception e)
		{
		}
		
		finally
		{
			this.desconectar();
		}
		return list;
	}

}
