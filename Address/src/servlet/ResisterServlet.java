package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBook;
import model.InputAddressBook;
import model.ResisterLogic;

@WebServlet("/ResisterServlet")
public class ResisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resister.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		
		String inputName = request.getParameter("name");
		String inputGender = request.getParameter("gender");
		String inputPhoneNumber = request.getParameter("phoneNumber");
		String inputEmailAddress = request.getParameter("emailAddress");
		String inputPostalcode = request.getParameter("postalcode");
		String inputAddress1 = request.getParameter("address1");
		String inputAddress2 = request.getParameter("address2");
		String inputAddress3 = request.getParameter("address3");
		String inputAddress4 = request.getParameter("address4");
		String inputAddress5 = request.getParameter("address5");
		String inputBirth = request.getParameter("birth");
		
		String inputBirthPlace = request.getParameter("birthPlace");
		
		InputAddressBook inputAddressBook = new InputAddressBook("id", inputName, inputGender, inputPhoneNumber, inputEmailAddress, inputPostalcode, inputAddress1, inputAddress2, inputAddress3, inputAddress4,  inputAddress5, inputBirth, "", inputBirthPlace);
		
		//エラーチェック
		String errorMsg = inputAddressBook.errorCheck();
		if(!errorMsg.equals("")) {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("inputAddressBook", inputAddressBook);
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resister.jsp");
			dispatcher.forward(request, response);
		}else {
			AddressBook addressBook = new AddressBook(inputAddressBook);
			
			ResisterLogic resisterLogic = new ResisterLogic();
			if(resisterLogic.execute(addressBook)) {
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resisterResult.jsp");
				dispatcher.forward(request, response);
			}else {
				//エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", "登録に失敗しました");
				request.setAttribute("inputAddressBook", inputAddressBook);
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/resister.jsp");
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
		
	}
}
