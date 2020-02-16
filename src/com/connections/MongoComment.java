package com.connections;

import java.util.ArrayList;

import com.classes.Commentary;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class MongoComment {		
	    DatabaseImpossible db=DatabaseImpossible.getDatabaseImpossible();
	
	public ArrayList<Commentary> read(String integral)
	{
		DBCollection coll=db.getDatabaseColumn(integral);
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
		DBCollection coll=db.getDatabaseColumn(integral);
		BasicDBObject obj= new BasicDBObject("name",co.getName()).append("text", co.getText());
		coll.insert(obj);
	}
}
