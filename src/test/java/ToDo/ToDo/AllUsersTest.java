package ToDo.ToDo;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.*;


public class AllUsersTest {
	
	
	
	
	@BeforeClass
	public static void setup() throws SQLException {
		DataBase d=new DataBase();
		d.build();
		d.dummyData();
		
		
	}
	
	
	
	
	@Test
	public void generateIDTest() throws SQLException {
		AllUsers users=new AllUsers();
		assertEquals(3,users.generateID());	
		
	}
	
	@Test
	public void newUserTest() throws SQLException {
		AllUsers users=new AllUsers();
		users.newUser("new guy", "new guy");
	}
	

}
