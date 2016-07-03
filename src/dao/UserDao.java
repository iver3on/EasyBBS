package dao;

import pojo.User;

public interface UserDao {
	public int addUser(User u);
	public User login(String uname,String psd);
}
