import java.sql.SQLException;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) throws SQLException {
		DataBase d=new DataBase();
		d.build();
		d.dummyData();
		AllUsers users=new AllUsers();
		
		users.newUser("liam", "123");
		System.out.println(users.getUsers().get(2).getUserID());
	}

}
