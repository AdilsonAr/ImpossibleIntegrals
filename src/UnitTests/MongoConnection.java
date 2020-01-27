package UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.connections.MongoComment;
import com.mongodb.DB;
import com.mongodb.DBCollection;

class MongoConnection {

	@Test
	void test() {
		MongoComment mongo=new MongoComment();
		String integral="";
		DBCollection coll=mongo.Collection(integral);	
		assertNotNull(coll);
	}

}
