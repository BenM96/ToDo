package ToDo.ToDo.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class AllItems {
	
	private ArrayList<Item> items= new ArrayList<Item>();
	
	public AllItems() throws SQLException {
		DataBase d= new DataBase();
		this.items=d.loadItems();
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