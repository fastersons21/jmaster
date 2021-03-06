package sht.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.bean.PersonBean;
import sht.business.CalcAge;

/**
 * Servlet implementation class ShowAgeServlet
 */
@WebServlet("/ShowAgeServlet")
public class ShowAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAgeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String strYear = request.getParameter("year");
		String strMonth = request.getParameter("month");
		String strDate = request.getParameter("date");

		if(strYear == null || strYear.length() == 0 || strMonth == null
				||strMonth.length() == 0 || strDate == null
				|| strDate.length() == 0) {
			request.setAttribute("message", "生年月日を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("/errInput.jsp");
			rd.forward(request, response);
			return;
		}


		int year,month,date;
		try {
			year = Integer.parseInt(strYear);
			month = Integer.parseInt(strMonth);
			date = Integer.parseInt(strDate);
		}catch (NumberFormatException e) {
			request.setAttribute("message", "生年月日は数値を入力してください");
			RequestDispatcher rd = request.getRequestDispatcher("errInput.jsp");
			rd.forward(request, response);
			return;
		}

		CalcAge ca = new CalcAge();
		int age = ca.howOld(year,month,date);

		PersonBean p = new PersonBean(name,age);

		request.setAttribute("person", p);
		RequestDispatcher rd = request.getRequestDispatcher("/showAge.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
