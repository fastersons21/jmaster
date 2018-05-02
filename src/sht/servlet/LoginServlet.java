package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	//データベースの代わりにこのユーザー名とパスワードを正しいとする
	private static final String USER="jack";
	private static final String PASS="abc";

    /**
     * @see HttpServlet#HttpServlet()
     */
        // TODO Auto-generated constructor stub


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//actionリクエストパラメータの読み込み
		String action = request.getParameter("action");
		if(action.equals("login")) {
			//ログイン時はユーザー名とパスワードを取得する
			//パラメータのエラーチェックは省略

			String name=request.getParameter("name");
			String passWord=request.getParameter("pw");
			//ユーザー名とパスワードが一致したら
			if(name.equals(USER)&&passWord.equals(PASS)) {
				//セッション管理を行う
				HttpSession session=request.getSession();
				//ログイン済みの属性を設定する
				session.setAttribute("isLogin", "true");
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ログイン成功</h1>");
			}else {
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ユーザー名またはパスワードが違います</h1>");
			}
		}else if(action.equals("logout")) {//ログアウト時
			//すでに作成されているセッション領域を取得する。新しくは作成しない
			HttpSession session = request.getSession(false);
			if(session != null) {
				//セッション領域を無効にする
				session.invalidate();
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ログアウトしました</h1>");
			}
		}
		out.println("<a href='/jmaster/selectProduct.html'>戻る</a>");
		out.println("</body></html>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}