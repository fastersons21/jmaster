package sht.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

@WebServlet("/AppServlet")
public class AppDao {
//	private Connection con;
	private static String driverName ="com.mysql.jdbc.Driver";//ログインするDBの場所を指定する
	static String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC";
	static String user = "student";//MySQLにログインする為の情報を入力
	static String pass ="himitu";
	public static  ArrayList<String> getConnection() {
		Connection con = null;
		ArrayList<String> daoUser = new ArrayList<String>();
		try{
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,pass);
			String sql ="SELECT * FROM user";

			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			String name = null;
			String dbpass = null;

			while(rs.next()) {
				name = rs.getString("name");
				dbpass = rs.getString("pass");
			}

				daoUser.add(name);
				daoUser.add(dbpass);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return daoUser;

//			finally {
//			try {
//				if(rs !=null)rs.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}

	}
}
