package dao;

import java.util.List;

import pojo.Message;

public interface MessageDao {
	public int push(Message m);
	public List<Message> findAll(String sql);
	public Message loadMessage(int id);
	
}
