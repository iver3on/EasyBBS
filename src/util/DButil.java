package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButil {
	public static String dbip="127.0.0.1";
	public static Connection getConnection(){
		String url="jdbc:oracle:thin:@"+dbip+":1521:xe";
		String user="john";
		String password="234";
		String driverClass="oracle.jdbc.OracleDriver";
		Connection con=null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("请检查下项目中是否有驱动程序！客服电话：1112233");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static  void  close(Connection con,PreparedStatement pst,ResultSet rs){
		try {
			if(rs!=null)
			rs.close();
			if(pst!=null)
			pst.close();
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Connection con=DButil.getConnection();
		System.out.println(con);
	}
}
