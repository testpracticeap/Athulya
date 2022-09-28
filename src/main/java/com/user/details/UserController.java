package com.user.details;

import java.net.URI;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	@RequestMapping("/sample/")
	public User Sample(@RequestParam(value = "name", defaultValue = "Robot") String name) {
		User user = new User();
		user.setId(1);
		user.setName("hi " + name);
		// user.setEmail(name)
		return user;
	}

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserList getUsers() {
		UserDAO userdao = new UserDAO();
		return userdao.getAllUsers();

	}

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		UserDAO userdao = new UserDAO();

		Integer id = userdao.getAllUsers().getUserList().size() + 1;

		user.setId(id);

		userdao.addUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
}
