package UnitTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.connections.DatabaseImpossible;
import com.mongodb.DBCollection;

class MongoConnection {

	@Test
	void test() {
		String integral="";
		DBCollection coll=DatabaseImpossible.getDatabaseImpossible().getDatabaseColumn(integral);	
		assertNotNull(coll);
	}

}
