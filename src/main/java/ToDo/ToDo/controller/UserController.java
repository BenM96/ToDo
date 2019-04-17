package ToDo.ToDo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ToDo.ToDo.model.User;


@RestController
@RequestMapping("api/v1/")
public class UserController {
	
	@RequestMapping(value="users", method=RequestMethod.GET)
	public List<User> list(){
		return UsersStub.list();
	}
	
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return UsersStub.create(user);
    }


	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable Long id, @RequestBody User user){
        return UsersStub.update(id, user);
    }
	
	@RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public User delete(@PathVariable Long id){
        return UsersStub.delete(id);
    }


	
}
