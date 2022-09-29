package com.user.details;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	@RequestMapping("/reqParam/")
	public User Param(@RequestParam(value = "name", defaultValue = "Athulya") String name) {
		User user = new User();
		user.setId(1);
		user.setName(name);
		return user;
	}

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserList getUsers() {
		UserDAO userdao = new UserDAO();
		return userdao.getAllUsers();

	}

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		UserDAO userdao = new UserDAO();
		Integer id = userdao.getAllUsers().getUserList().size() + 1;
		user.setId(id);
		userdao.addUser(user);
		return user;
	}

	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable(value = "id") int id, @RequestBody User user)
			throws ResourceNotFoundException {

		User user1 = UserDAO.findById(id);
		user1.setName(user.getName());
		user1.setAddress(user.getAddress());
		user1.setEmail(user.getEmail());
		return user1;
	}

}

class ResourceNotFoundException extends Exception {
 // just to throw exception
}
