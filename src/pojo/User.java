package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	private Integer id;
	private String uname;
	private String psd;
	private Date birh;
	private int level;
	private List<Message> msgs=new ArrayList<Message>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public Date getBirh() {
		return birh;
	}
	public void setBirh(Date birh) {
		this.birh = birh;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<Message> getMsgs() {
		return msgs;
	}
	public void setMsgs(List<Message> msgs) {
		this.msgs = msgs;
	}
	
	
}
