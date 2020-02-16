package com.connections;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class DatabaseImpossible 
{
private static DatabaseImpossible db = null;
private static DB database=null;
private static MongoClient mongoClient=null;

	private DatabaseImpossible()
	{	
		try {

			mongoClient = new MongoClient("localhost", 27017);
			database = mongoClient.getDB("ImpossibleIntegrals");
		}
 
		catch (Exception e) {
		}
	}
	
	public static DatabaseImpossible getDatabaseImpossible()
	{
		if (db==null)
		{
			db= new DatabaseImpossible();
		}
		return db;
	}
	
	public DBCollection getDatabaseColumn(String integral) {
		DBCollection coll =database.getCollection(integral);
		return coll;
	} 
}
