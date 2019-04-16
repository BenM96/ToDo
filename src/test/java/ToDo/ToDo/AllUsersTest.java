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
		assertEquals(4,users.generateID());	
	}
	
	@Test
	public void getUsernameTest() throws SQLException {
		AllUsers users=new AllUsers();
		assertEquals("archer",users.getUsername(1));
		assertEquals("bilbo",users.getUsername(2));
		assertEquals("",users.getUsername(3));
	}
	
	@Test
	public void getIDtest() throws SQLException {
		AllUsers users=new AllUsers();
		assertEquals(1,users.getID("archer"));
		assertEquals(2,users.getID("bilbo"));
		assertEquals(0,users.getID("adfasdf"));
		
	}
	
	@Test
	public void getPasswordTest() throws SQLException {
		AllUsers users=new AllUsers();
		assertEquals("guest",users.getPassword(1));
		assertEquals("time",users.getPassword(2));
		assertEquals("",users.getPassword(3));
	}
	
	@Test
	public void removeUserTest() throws SQLException {
		AllUsers users=new AllUsers();
		users.removeUser(1);
		assertEquals("",users.getUsername(1));

	}
}
