package pojo;

import java.util.ArrayList;
import java.util.List;

public class Message {
	private Integer id;
	private String title;
	private String content;
	private User u;
	private Message oriMessage;
	private List<Message> msgs=new ArrayList<Message>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public Message getOriMessage() {
		return oriMessage;
	}
	public void setOriMessage(Message oriMessage) {
		this.oriMessage = oriMessage;
	}
	public List<Message> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<Message> msgs) {
		this.msgs = msgs;
	}
	
}
