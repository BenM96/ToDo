import java.sql.SQLException;
import java.util.ArrayList;

public class AllUsers {
	private ArrayList<User> users;
	
	
	public AllUsers() throws SQLException {
		DataBase d= new DataBase();
		this.users=d.loadUsers();
	}
	
	public void newUser(String username, String password) {
		int userID=generateID();
		User newUser= new User(userID,username,password);
		users.add(newUser);
	}
	
	public int generateID() {
		int id=0;
		while(true) {
			id++;
			for(User user : users) {
				if (user.getUserID()==id) {
					System.out.println(id);
					continue;
				}
			}
			return id;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}






}

