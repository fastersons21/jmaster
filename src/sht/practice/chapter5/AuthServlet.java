package sht.practice.chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final String USER="joe";
	private static final String PASS="xyz";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		if(action.equals("login")) {

			String name = request.getParameter("name");
			String passWord = request.getParameter("pw");

			if(name.equals(USER)&&passWord.equals(PASS)) {
				HttpSession session = request.getSession();

				session.setAttribute("isLogin", "true");
				out.println("<html><head><title>Confirmed</title></head><body><h1>");
				out.println(name + "さん、こんにちは。");
				out.println("ログイン成功しました</h1>");
				out.println("<hr><a href='/jmaster/practice/chapter5/index.html'>商品選択に戻る</a>");
				out.println("</head></html>");
			}else {
				out.println("<html><head><title>Confirmed</title></head><body>");
				out.println("<h1>ユーザー名またはパスワードが違います。</h1>");
				out.println("<hr><a href='/jmaster/practice/chapter5/index.html'>戻る</a>");
			}

		} else if(action.equals("logout")) {

				HttpSession session = request.getSession(false);
				if(session != null) {

					session.invalidate();
					out.println("<html><head><title>Confirmed</title></head><body>");
					out.println("<h1>ログアウトしました</h1>");
					out.println("<hr><a href='/jmaster/practice/chapter5/index.html'>ログイン情報入力画面に戻る</a>");
					out.println("</head></html>");


			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
