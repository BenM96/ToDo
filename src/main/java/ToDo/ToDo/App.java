package ToDo.ToDo;


import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ToDo.ToDo.model.AllItems;
import ToDo.ToDo.model.AllUsers;
import ToDo.ToDo.model.DataBase;


@SpringBootApplication
public class App {
	public static void main(String[] args) throws SQLException {
		AllUsers users=new AllUsers();
		AllItems items=new AllItems();
		
		
		SpringApplication.run(App.class, args);

	}

}
