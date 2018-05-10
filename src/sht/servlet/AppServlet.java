package sht.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {
	//参照するtableを持ってくる

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Class.forName("com.mysql.jdbc.Driver");

		//actionリクエストパラメータの読み込み
		String action = request.getParameter("name");
		String pass1 = request.getParameter("pass");

		String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC";
		String user = "student";
		String pass ="himitu";
		Connection con = DriverManager.getConnection(url,user,pass);
//		Statement stmt = con.createStatement();
		String sql = "SELECT * FROM user";
		PreparedStatement st =con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		String name = null;
		String dbpass = null;//ローカル変数をつくる場合は初期値を指定する必要がある。

		while(rs.next()) {//DBのレコードからデータをもってきて変数に格納する
			name = rs.getString("name");
			dbpass = rs.getString("pass");
		}
		if(action.equals(name)&&pass1.equals(dbpass)) {
			//セッション管理を行う
			HttpSession session=request.getSession();
			session.setAttribute("userName", name);//jspに渡すための名前をセットする
			//ログイン済みの属性を設定する
			RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");
			rd.forward(request,response);

		}

		} catch (Exception e) {
			System.out.println("DBエラー");
		}


	}

}
