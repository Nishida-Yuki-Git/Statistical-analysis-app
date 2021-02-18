package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Entry;
import model.EntryLogic;

/**
 * Servlet implementation class EntryServlet
 */
@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/jsp/Entry.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		if (userId == "" || pass == "" || mail == "" || name == "" || ageStr == "") {
			response.sendRedirect("/myApp/EntryServlet");
			System.out.println("入力ミス発見");
		} else {
			int age = Integer.parseInt(ageStr);

			//ユーザー登録処理を実行
			Entry entry = new Entry(userId, pass, mail, name, age);
			EntryLogic bo = new EntryLogic();
			boolean result = bo.execute(entry);

			if (result) {
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"/WEB-INF/jsp/entryOK.jsp");
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("/myApp/EntryServlet");
			}
		}
	}
}
