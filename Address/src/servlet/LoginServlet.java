package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AddressBookUser;
import model.Login;
import model.LoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("userId");
		String password = request.getParameter("password");

		//ログイン処理
		Login login = new Login(id, password);
		LoginLogic loginLogic = new LoginLogic();
				
		if(loginLogic.execute(login)) {
			//セッションスコープにユーザーIDを保存
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
			dispatcher.forward(request, response);
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "idまたはパスワードが正しくありません");
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
}