package ToDo.ToDo.model;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {
	
	public final String DB_URL="jdbc:mysql://localhost:3306/todo";
	public final String USER = "root";
	public final String PASS = "";
	private Connection conn= null;
	private Statement stmt=null;
	
	public void build() throws SQLException {
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		stmt=conn.createStatement();
		stmt.executeUpdate("drop table if exists list_items;");
		stmt.executeUpdate("drop table if exists users;");
		stmt.executeUpdate("create table users(user_id int, username varchar(20) not null unique, password varchar(20) not null,primary key(user_id));");
		stmt.executeUpdate("create table list_items(item_id int, user_id int, list_item varchar(100),list_name varchar(50),completed tinyint, primary key(item_id), foreign key(user_id) references users(user_id));");
		stmt.close();
	}

	public void saveUser(int userID,String username,String password) throws SQLException{
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		stmt=conn.createStatement();
		stmt.executeUpdate("insert into users(user_id,username,password) values("+userID+",'"+username+"','"+password+"');");
		stmt.close();
	}
	
	public void saveUser(User user) throws SQLException {
		saveUser(user.getUserID(), user.getUsername(),user.getPassword());
	}	
		
	public void saveItem(int itemID, int userID,String desc,String listName, boolean completed) throws SQLException {
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		stmt=conn.createStatement();
		int completed10=0;
		if(completed) {
			completed10=1;
		}
		
		stmt.executeUpdate("insert into list_items(item_id, user_id,list_item,list_name,completed) values("+itemID+",'"+userID+"','"+desc+"','"+listName+"',"+completed10+");");
		
	}
		
	public void saveItem(Item item) throws SQLException {
		saveItem(item.getItemID(),item.getUserID(),item.getDesc(),item.getListName(),item.isCompleted());
	}
	
	public ArrayList<User> loadUsers() throws SQLException{
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		stmt=conn.createStatement();
		ResultSet rs= stmt.executeQuery("select * from users");
		ArrayList<User> users=new ArrayList<User>();
		while(rs.next()) {
			int userID=rs.getInt("user_id");
			String username=rs.getString("username");
			String password=rs.getString("password");
			User nextUser= new User(userID,username,password);
			users.add(nextUser);
		}		
		stmt.close();
		return users;
	}
	
	public ArrayList<Item> loadItems() throws SQLException{
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from list_items");
		ArrayList<Item> items= new ArrayList<Item>();
		while(rs.next()) {
			int listItemID=rs.getInt("item_id");
			int userID=rs.getInt("user_id");
			String Item=rs.getString("list_Item");
			String listName=rs.getString("list_name");
			int completed=rs.getInt("completed");
			Item nextItem=new Item(listItemID,userID,Item,listName,completed);
			items.add(nextItem);
		}
		stmt.close();
		return items;
	}


		
	public void dummyData() throws SQLException {
		saveUser(1,"archer", "guest");
		saveUser(2,"bilbo","time");
		saveItem(1,1,"drink sum","first",false);
		saveItem(2,1,"drink more","first",false);
		saveItem(3,1,"heist","first",false);
		saveItem(4,2,"help dwarfs","the hobbit",false);
		saveItem(5,2,"kill dragon","the hobbit",false);
		saveItem(6,2,"give ring to frodo","lotr",false);
		saveItem(7,2,"celibrate bday","lotr",false);
		saveItem(8,2,"get old","lotr",false);			
	}



}
