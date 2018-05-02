package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymetServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
//    public PaymetServlet() {
//        super();
        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//			throws ServletException, IOException {
		String payment = request.getParameter("pay");
		String[] values = request.getParameterValues("site");
		String selectedPayment;
		if(payment == null) {
			selectedPayment = "選択されていません";
		}else {
			switch (payment) {
			case "card":
				selectedPayment ="クレジットカード";
				break;
			case "bank":
				selectedPayment ="銀行振込";
				break;
			case "cash":
				selectedPayment ="代引き";
				break;
			default:
				selectedPayment ="???";
				break;
			}
		}
		String selectedSite = "-";
		if(values == null) {
			selectedSite ="選択されていません";
		}else {
			//複数の値をループで取り出す
			for(String site:values) {
				switch(site) {
				case "fb":
					selectedSite += "facebook" + "-";
					break;
				case "tw":
					selectedSite += "Twitter" + "-";
					break;
				case "yt":
					selectedSite += "YouTube" + "-";
					break;
				default:
					selectedSite += "???" + "-";
					break;
				}
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		out.println("<html><head><title>Payment</title></head><body>");
		out.println("あなたが選択したお支払方法は以下の通りです<br/>");
		out.println("[" + selectedPayment + "]");
		out.println("<br/><br/>");
		out.println("あなたが選択したサービスは以下の通りです<br/>");
		out.println("[" + selectedSite + "]");
		out.println("</body></html>");
		}
	}

