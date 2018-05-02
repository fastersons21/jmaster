package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourNameServlet
 */
@WebServlet("/YourNameServlet")
public class YourNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>YourName</title></head><body>");
		out.println("あなたの名前は「" + name + "」さんですね。");
		out.println("</body></html>");

	}

    /**
     * @see HttpServlet#HttpServlet()
     */
//    public YourNameServlet() {
//        super();
        // TODO Auto-generated constructor stub


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
