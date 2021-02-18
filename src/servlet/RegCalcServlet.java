package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetRegCalcLogic;
import model.PostRegCalcLogic;
import model.RegResult;

/**
 * Servlet implementation class RegCalcServlet
 */
@WebServlet("/RegCalcServlet")
public class RegCalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//解析結果リストを取得して、リクエストスコープに保存
		GetRegCalcLogic getList = new GetRegCalcLogic();
		List<RegResult> RegressionList = getList.execute();
		request.setAttribute("RegressionList", RegressionList);

		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/regCalc.jsp");
		disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String analysisName = request.getParameter("analysisName"); //分析名称
		String paramX = request.getParameter("xNumList");
		String paramY = request.getParameter("yNumList");

		if (analysisName != null && analysisName.length() != 0 && paramX != null && paramX.length() != 0 && paramY != null && paramY.length() != 0) {
			String[] paramXList = paramX.split(" ");
			String[] paramYList = paramY.split(" ");
			List<Double> xNumList = new ArrayList<>(); //計算に使用するリスト
			List<Double> yNumList = new ArrayList<>(); //計算に使用するリスト
			for (String x : paramXList) {
				double xNum = Double.parseDouble(x);
				xNumList.add(xNum);
			}
			for (String y : paramYList) {
				double yNum = Double.parseDouble(y);
				yNumList.add(yNum);
			}
			if (xNumList.size() != yNumList.size()) {
				request.setAttribute("errorMsg", "2つのデータ群の要素数が違います");
			} else {
				//計算処理をして、DBに保存
				PostRegCalcLogic postLogic = new PostRegCalcLogic();
				postLogic.execute(analysisName, xNumList, yNumList);

				//解析結果リストをリクエストスコープに保存
				GetRegCalcLogic getList = new GetRegCalcLogic();
				List<RegResult> RegressionList = getList.execute();
				request.setAttribute("RegressionList", RegressionList);
			}
		} else {
			request.setAttribute("errorMsg", "全て入力してください");
		}
		//先程の画面にフォワード
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/jsp/regCalc.jsp");
		disp.forward(request, response);
	}
}












