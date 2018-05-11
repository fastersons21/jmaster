package sht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.dao.AppDao;


@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {
	//参照するtableを持ってくる

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//
//		//login.jspで入力された情報を属性を引数にして変数名をつけてもってくる
//		String action = request.getParameter("name");
//		String pass1 = request.getParameter("pass");
//		//mysqlに入る為の権限を付与する
//		String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC";
//		String user = "student";
//		String pass ="himitu";
//		//url,user,passをまとめて変数をつける
//		Connection con = DriverManager.getConnection(url,user,pass);
//		//ｓｑｌからもってくるuserを指定する
//		String sql = "SELECT * FROM user";
//		//PreparedStatementつかって
//		PreparedStatement st =con.prepareStatement(sql);
//		ResultSet rs = st.executeQuery();
//
//		String name = null;
//		String dbpass = null;//ローカル変数をつくる場合は初期値を指定する必要がある。
//
//		while(rs.next()) {//DBのレコードからデータをもってきて変数に格納する
//			name = rs.getString("name");//DBからデータを持ってくるにはwhileを使う
//			dbpass = rs.getString("pass");
//		}
		AppDao dao = new AppDao();

		List<String> list = dao.findAll();
		String name1= list.get(0);
		String pass1 = list.get(1);


		if(action.equals(name)&&pass1.equals(dbpass)) {//入力されたデータとDBのデータが一致するか確認
			//セッション管理を行う
			HttpSession session=request.getSession();
			session.setAttribute("userName", name);//jspに渡すための名前をセットする(新しくmypageに持って行くときの名前,参照する変数名)
			//ログイン済みの属性を設定する
			RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");//どこに持って行くか指定する
			rd.forward(request,response);//forwardメソッドで送る変数を指定する
		}
	}
}

//		}
//
//		} catch (Exception e) {
//			System.out.println("DBエラー");
//		}


//	}
//
//}
