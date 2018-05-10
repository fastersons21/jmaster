package sht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.bean.ItemBean;
import sht.dao.DAOException;
import sht.dao.ItemDAO;

@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータの解析は特に無し
		//モデルを使って全商品を取得する
		try {
			ItemDAO dao = new ItemDAO();
			List<ItemBean> list = dao.findAll();
			//Listをリクエストスコープに入れてＪＳＰへフォワードする
			request.setAttribute("items",list);
			RequestDispatcher rd = request.getRequestDispatcher("/showItem.jsp");
			rd.forward(request,response);
		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message","内部エラーが発生しました。");
			RequestDispatcher rd =
					request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
