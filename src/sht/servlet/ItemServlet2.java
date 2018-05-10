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
import sht.dao.ItemDAO2;

/**
 * Servlet implementation class ItemServlet2
 */
@WebServlet("/ItemServlet2")
public class ItemServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			//パラメータの解析
			String action = request.getParameter("action");
			//モデルのDAOを生成
			ItemDAO2 dao = new ItemDAO2();
			//パラメータなしの場合は全レコード表示
			if(action == null || action.length() == 0) {
				List<ItemBean> list = dao.findAll();
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem2.jsp");
				//addは追加
			}else if(action.equals("add")) {
				String name = request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				dao.addItem(name, price);
				//追加後、全レコード表示
				List<ItemBean> list= dao.findAll();
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem2.jsp");
			}
			//sortはソート
			else if(action.equals("sort")) {
				String key = request.getParameter("key");
				List<ItemBean> list;
				if(key.equals("price_asc"))
					list = dao.sortPrice(true);
				else
					list = dao.sortPrice(false);
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items",list);
				gotoPage(request,response,"/showItem2.jsp");
			}
			//searchは結果
			else if(action.equals("search")) {
				int price = Integer.parseInt(request.getParameter("price"));
				List<ItemBean> list = dao.findByPrice(price);
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem2.jsp");
			}
			//deleteは削除
			else if(action.equals("delete")) {
				int code = Integer.parseInt(request.getParameter("code"));
				dao.deleteByPrimaryKey(code);
				//削除後、全レコード表示
				List<ItemBean> list = dao.findAll();
				//ListをリクエストスコープにいれてJSPへフォワードする
				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem2.jsp");
			}else {
				request.setAttribute("message", "正しく操作してください");
				gotoPage(request,response,"/errInternal.jsp");
			}
		}catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました");
			gotoPage(request,response,"/errInternal.jsp");
		}
	}

	protected void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
