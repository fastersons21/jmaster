package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestInfoServlet
 */
@WebServlet("/RequestInfoServlet")
public class RequestInfoServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
//    public RequestInfoServlet() {
//        super();
        // TODO Auto-generated constructor stub


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>requestInformation</title></head><body>");
			out.println("リクエスト情報を表示します<br><br>");

			out.println("リモートIPアドレス:" + request.getRemoteAddr() + "<br>");
			out.println("リクエストURI:" + request.getRequestURI() + "<br>");
			out.println("HTTPメソッド:" + request.getMethod()+ "<br>");
			out.println("ブラウザの種類:" + request.getHeader("User-Agent") + "<br>");
			out.println("利用可能ファイル種別:" + request.getHeader("Accept") + "<br>");
			out.println("利用可能言語" + request.getHeader("Accept-Language") + "<br>");

			out.println("</body></html>");
	}


}
