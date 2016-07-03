package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Message;
import pojo.User;
import util.DButil;
import dao.MessageDao;

public class MessageDaoImpl implements MessageDao {

	@Override
	public List<Message> findAll(String sql) {
		List<Message> msgs=new ArrayList<Message>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sq="select m.id id,m.title title,u.uname uname from message m,users u where m.u_id=u.id and m.m_id=0";
		con=DButil.getConnection();
		try {
			pst=con.prepareStatement(sq);
			
			rs=pst.executeQuery();
			if(rs.next()){
				Message m=new Message();
				m.setId(rs.getInt("id"));
				m.setTitle(rs.getString("title"));
				User u = new User();
				u.setUname(rs.getString("uname"));
				m.setU(u);
				msgs.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		finally{
			DButil.close(con, pst, rs);
		}
		
		return msgs;
	}

	@Override
	public Message loadMessage(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int push(Message msg) {
		int m=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		String sql="insert into message (id,title,content,u_id,m_id) values(seq_users.nextval,?,?,?,?)";
		
		con=DButil.getConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1,msg.getTitle());
			pst.setString(2,msg.getContent());
			pst.setInt(3,msg.getU().getId());
			if(msg.getOriMessage()!=null)
				pst.setInt(4,msg.getOriMessage().getId());
			else
				pst.setInt(4,0);
			
			m=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println("数据库进行操作时出现了异常，请检查SQL语句");
		}
		finally{
			DButil.close(con, pst, null);
		}
		return m;
	}
	
	public static void main(String[] args) {
		MessageDaoImpl md=new MessageDaoImpl();
		
//		Message m=new Message();
//		m.setTitle("f1");
//		m.setContent("f1c1c1c1c1");
//		User u = new User();
//		u.setId(1);
//		m.setU(u);
//		
//		Message mm = new Message();
//		mm.setId(2);
//		m.setOriMessage(mm);
//		
//		md.push(m);
		
		List<Message> ms=md.findAll("");
		System.out.println(ms.size());
		
	}

}
