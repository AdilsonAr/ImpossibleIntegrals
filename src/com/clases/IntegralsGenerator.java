package com.clases;
import java.io.File;
import java.lang.reflect.*;
import java.util.*;

import com.Connections.DAOIntegralObject;

public class IntegralsGenerator {

	public static void main(String[] args) {
		String path="C:\\Users\\KGB\\Desktop\\Java\\Workspace\\ImpossibleIntegrals\\src\\com\\integrals";
		File folder=new File(path);
		String [] list=folder.list();			
				
		DAOIntegralObject dao=new DAOIntegralObject();
		int n=list.length;
		ArrayList<IntegralObject> resources=dao.read();
		for(int i=0;i<n;i++)
		{
			String currentName=list[i].substring(0, list[i].length()-5);
			boolean found=false;
			for(IntegralObject current:resources)
			{
				if(current.getClassName().equalsIgnoreCase(currentName))
				{
					found=true;
				}
			}
			
			if(!found)
			{
				try
				{
					IntegralObject obj=new IntegralObject();
					Class<?> element=Class.forName("com.integrals."+currentName);
					Object element2=element.newInstance();
					
					Method getName =element.getMethod("getName");
					Object description=getName.invoke(element2);
					obj.setDescription(description.toString());
					obj.setClassName(currentName);
					dao.add(obj);
				}
				
				catch(Exception e)
				{					
				}
			}
		}
		
	}
}