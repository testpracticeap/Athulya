package com.user.details;

import java.util.Iterator;

public class UserDAO {
	public static UserList list = new UserList();

	static {
		list.getUserList().add(new User(1, "Athulya", "athul@gmail.com", "9876533267", "Kannur"));

		list.getUserList().add(new User(2, "Nibin", "nibin@gmail.com", "9564657659", "Bangalore"));

		list.getUserList().add(new User(3, "Adarsh", "adarsh@gmail.com", "6656434878", "Mumbai"));

		list.getUserList().add(new User(3, "Ashin", "ashin@gmail.com", "9876654332", "Calicut"));
	}

	public UserList getAllUsers() {
		return list;
	}

	public void addUser(User user) {
		list.getUserList().add(user);

	}

	public static User findById(int id) {
		for (User user : list.getUserList()) {
	        if (user.getId()==id) {
	            return user;
	        }
	    }
	    return null;
	}

}
