package sht.practice.chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if(session == null) {
			out.println("<html><head><title>ShowCart</title></head><body>");
			out.println("<h1>ログインしてください</h1>");
			out.println("<hr><a href='/jmaster/practice/chapter5/index.html'>戻る</a>");
			return;
		}else {
			String isLogin = (String)session.getAttribute("isLogin");
			if(isLogin == null || !isLogin.equals("true")) {
				out.println("<html><head><title><ShowCart></title></head><body>");
				out.println("<h1>ログインしてください<h2>");
				out.println("<hr><a href='/jmaster/practice/chapter5/index.html'>戻る</a>");
				return;
			}
		}

		String productNo  = request.getParameter("product_no");
		int no = Integer.parseInt(productNo);
		String productName = null;

		switch (no) {
		case 100:
			productName = "火花";
			break;
		case 101:
			productName = "何者";
			break;
		case 102:
			productName = "Dive";
			break;
		default:
			productName = "???";
		}

//		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<String> cart = (ArrayList<String>) session.getAttribute("products");
		if(cart == null) {
			cart = new ArrayList<String>();
			session.setAttribute("products", cart);
		}

		cart.add(productName);

		out.println("<html><head><title>Confirmed</title></head><body>");
		out.println("現在のカートの中身は以下の通りです<br/>");
		for(int i = 0; i < cart.size(); i++) {
			out.println(i + 1);
			out.println(":" + cart.get(i) + "<br/>");
		}

		out.println("<hr><a href='/jmaster/practice/chapter5/index.html'>商品リスト</a>");
		out.println("</body></html>");
	}
}
