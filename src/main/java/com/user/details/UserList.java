package com.user.details;

import java.util.ArrayList;
import java.util.List;



public class UserList {
	public List<User> userList;

	// Method to return the list of users
	public List<User> getUserList() {

		if (userList == null) {

			userList = new ArrayList<>();

		}

		return userList;

	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
