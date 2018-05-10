package sht.practice.chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class no003
 */
@WebServlet("/no003")
public class no003 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public no003() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("userName");
		String pass = request.getParameter("userPass");
		String mail = request.getParameter("userEadress");

		out.println("<html><head><title>登録確認</title></head><body>");
		out.println("<h1>登録確認</h1>");
		out.println(name + "<br/>" + pass + "<br/>" + mail);
		out.println("</body></html>");
	}


}
