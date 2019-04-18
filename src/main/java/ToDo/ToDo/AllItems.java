package ToDo.ToDo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllItems {
	
	private ArrayList<Item> items= new ArrayList<Item>();
	
	
	public AllItems()  {
		DataBase d= new DataBase();
		try {
			this.items=d.loadItems();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	
	public void editItem(Item item) {
		int id = item.getItemID();
		int index= items.indexOf(getItem(id));
		this.items.set(index, item);
		
	}
	
	
	public int generateID() {
		int id=0;
		while(true) {
			id++;
			boolean unique= true;
			for(Item item: items) {
				if (item.getItemID()==id) {
					unique=false;
					break;
				}				
			}
			if (unique) {
				return id;
			}
		}
	}

	public ArrayList<Item> getListItems(int userID, String listName){
		ArrayList<Item> listItems=new ArrayList<Item>();
		
		for(Item item : items) {
			if (item.getListName().equals(listName) && item.getUserID()==userID) {
				listItems.add(item);
			}
		}
		
		return listItems;
		
	}
	
	public Item getItem(int itemID) {
		for(Item item : items) {
			if(item.getItemID()==itemID) {
				return item;
			}
		}
		return null;
	}
	
	public ArrayList<Item> getItems() {
		return this.items;
		
	}
	
	public void addItem(int userID,String desc,String listName,boolean completed) {
		int listItemID = generateID();
		Item newItem= new Item(listItemID,userID,desc,listName,completed);
		items.add(newItem);
	}
	
	
	public void removeItem(int itemID) {
		for(Item item :items) {
			
			if(item.getItemID()==itemID) {				
				items.remove(item);
				return;

			}
		}
	}
	
}
