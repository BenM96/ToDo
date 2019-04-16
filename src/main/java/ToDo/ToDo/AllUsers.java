package ToDo.ToDo;


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
			boolean unique= true;
			for(User user : users) {
				if (user.getUserID()==id) {
					unique=false;
					break;
				}				
			}
			if (unique) {
				return id;
			}
		}
	}

	public String getUsername(int id) {
		for (User user :users) {
			if (user.getUserID()==id) {
				return user.getUsername();
			}
		}
		return "";
	}
	
	public int getID(String username) {
		for (User user :users) {
			if (user.getUsername().equals(username)) {
				return user.getUserID();
			}
		}
		return 0;
	}
	
	public String getPassword(int id) {
		for (User user :users) {
			if (user.getUserID()==id) {
				return user.getPassword();
			}
		}
		return "";
	}
	
	
	public void removeUser(int id) {
		for (User user :users) {
			if (user.getUserID()==id) {
				users.remove(user);
			}
		}
		
	}	
	
	
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}






}

