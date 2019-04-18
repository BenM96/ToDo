package ToDo.ToDo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ToDo.ToDo.AllItems;
import ToDo.ToDo.Item;


@RestController
@RequestMapping("api/v1/")
public class ItemController {
	
	AllItems items= new AllItems();	
	
	@RequestMapping(value="items", method=RequestMethod.GET)
	public List<Item> list() throws SQLException{
		return items.getItems();
	}
	
	
	@RequestMapping(value = "items", method = RequestMethod.POST)
    public Item create(@RequestBody Item item){
		items.addItem(item.getUserID(), item.getDesc(), item.getListName(), false);;
        return item;
    }

	

	@RequestMapping(value = "items", method = RequestMethod.PUT)
    public Item update(@RequestBody Item item){
		items.editItem(item);
		return item;
        
    }
	
	@RequestMapping(value = "item/{id}", method = RequestMethod.DELETE)
    public Item delete(@PathVariable Integer id){		
		Item item=items.getItem(id);
        items.removeItem(id);
        return item;
       
    }


	
}
