package com.connections;

import java.util.ArrayList;
import com.classes.Commentary;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;

public class MongoComment {
	
	public DBCollection Collection(String integral)
	{
		DBCollection coll=null;	
		try {
			MongoClient mongoClient=new MongoClient("localhost",27017);
			DB database=mongoClient.getDB("ImpossibleIntegrals");
			coll=database.getCollection(integral);
		}
		
		catch(Exception e){	
		}
		
		return coll;
	}
	
	public ArrayList<Commentary> read(String integral)
	{
		DBCollection coll=Collection(integral);
		Cursor cursor=coll.find();
		
		ArrayList<Commentary> list=new ArrayList();
		
		while(cursor.hasNext())
		{
			DBObject obj=cursor.next();
			Commentary com=new Commentary();
			com.setName(obj.get("name").toString());
			com.setText(obj.get("text").toString());
			list.add(com);
		}
		return list;
	}
	
	public void create(Commentary co,String integral)
	{	
		DBCollection coll=Collection(integral);
		BasicDBObject obj= new BasicDBObject("name",co.getName()).append("text", co.getText());
		coll.insert(obj);
	}
}
