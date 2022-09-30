package com.user.details;

public class UserDAO {
	public static UserList userlist = new UserList();

	static {
		userlist.getUserList().add(new User(1, "Athulya", "athul@gmail.com", "9876533267", "Kannur"));

		userlist.getUserList().add(new User(2, "Nibin", "nibin@gmail.com", "9564657659", "Bangalore"));

		userlist.getUserList().add(new User(3, "Adarsh", "adarsh@gmail.com", "6656434878", "Mumbai"));

		userlist.getUserList().add(new User(3, "Ashin", "ashin@gmail.com", "9876654332", "Calicut"));
	}

	public UserList getAllUsers() {
		
		return userlist;
	}

	public void addUser(User user) {
		userlist.getUserList().add(user);

	}

	public static User findById(int id) {
		for (User user : userlist.getUserList()) {
	        if (user.getId()==id) {
	            return user;
	        }
	    }
	    return null;
	}

	public static User deleteUser(int id) {
		User user=findById(id);
		userlist.getUserList().remove(user);
		return user;
	}

}
