package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteLogic;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("userId");
		
		DeleteLogic deleteLogic = new DeleteLogic();
		if(deleteLogic.execute(id)) {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteResult.jsp");
			dispatcher.forward(request, response);
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "削除に失敗しました");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
			dispatcher.forward(request, response);
		}
	}
}
