package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/hello")// アノテーション
public class HelloServlet extends HttpServlet {// httpservletを継承している
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>HelloServlet</title></head><body>");
//		out.println("<h1>ようこそ！HelloServletへ</h1>");
//		out.println("</body></html>");
		out.println("<html><head><title>HelloServlet</title></head><body>");
		for(int i = 0; i < 10; i++) {
			out.println("<h1>ようこそ！</h1>");
		}
		out.println("</body></html>");
	}

}
