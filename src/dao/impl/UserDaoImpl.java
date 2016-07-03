package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.User;
import util.DButil;
import dao.UserDao;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(User u) {
		int m=0;
		Connection con=null;
		PreparedStatement pst=null;
		
		String sql="insert into users (id,uname,psd,grade,birth) values(seq_users.nextval,?,?,?,?)";
		
		con=DButil.getConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, u.getUname());
			pst.setString(2,u.getPsd());
			pst.setInt(3,u.getLevel());
			Date d=new Date(u.getBirh().getTime());
			pst.setDate(4,d);
			m=pst.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("数据库进行操作时出现了异常，请检查SQL语句");
		}
		finally{
			DButil.close(con, pst, null);
		}
		return m;
	}

	@Override
	public User login(String uname, String psd) {
		User u=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select * from users where uname=? and psd=?";
		con=DButil.getConnection();
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, psd);
			rs=pst.executeQuery();
			if(rs.next()){
				u=new User();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setLevel(rs.getInt("grade"));
			}
		} catch (SQLException e) {
			
			System.out.println("数据库进行操作时出现了异常，请检查SQL语句");
		}
		finally{
			DButil.close(con, pst, rs);
		}
		
		return u;
	}
	
	public static void main(String[] args) {
		UserDaoImpl ud = new UserDaoImpl();
//		User u = new User();
//		u.setUname("john");
//		u.setPsd("123");
//		u.setLevel(10);
//		u.setBirh(new java.util.Date());
//		ud.addUser(u);
		
		User u=ud.login("john", "123");
		System.out.println(u.getLevel());
	}

}
