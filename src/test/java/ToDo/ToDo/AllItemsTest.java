package ToDo.ToDo;

import java.sql.SQLException;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ToDo.ToDo.model.AllItems;
import ToDo.ToDo.model.DataBase;

public class AllItemsTest {
	
	
	AllItems items;
	
	@BeforeClass
	public static void setup() throws SQLException {
		DataBase d=new DataBase();
		d.build();
		d.dummyData();		
	}
	
	
	@Before
	public void before() throws SQLException {
		items= new AllItems();
	}
	
	
	@Test	public void buildTest() {
	}
	
	public void generateIDTest() {
		assertEquals(9, items.generateID());
	}
	
	
	@Test
	public void getListItemsTest() {
		assertEquals(3,items.getListItems(1, "first").size());
		assertEquals(2,items.getListItems(2, "the hobbit").size());
		assertEquals(0,items.getListItems(1, "sober").size());
	}
	
	@Test
	public void getItemTest() {
		assertEquals("kill dragon",items.getItem(5).getDesc());
	}
	
	@Test
	public void addItem() {
		items.addItem(2, "go with elf", "lotr", false);
		assertEquals("go with elf",items.getItem(9).getDesc());
		assertEquals(10,items.generateID());
	}
	
	@Test
	public void revoveItemTest() {
		items.removeItem(3);
		assertNull(items.getItem(3));
	}
	
	

}
