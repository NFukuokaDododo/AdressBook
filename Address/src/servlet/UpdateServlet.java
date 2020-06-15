package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBook;
import model.InputAddressBook;
import model.UpdateLogic;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String inputId = request.getParameter("userId");
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
		String inputAge = request.getParameter("age");
		String inputBirthPlace = request.getParameter("birthPlace");
				
		InputAddressBook inputAddressBook = new InputAddressBook(inputId, inputName, inputGender, inputPhoneNumber, inputEmailAddress, inputPostalcode, inputAddress1, inputAddress2, inputAddress3, inputAddress4,  inputAddress5, inputBirth, inputAge, inputBirthPlace);
		
		//リクエストスコープにインスタンスを保存
		request.setAttribute("inputAddressBook", inputAddressBook);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
//		//リクエストパラメータの取得
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("userId");
//		String name = request.getParameter("name");
//		int gender = Integer.parseInt(request.getParameter("gender"));
//		Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
//		String emailAddress = request.getParameter("emailAddress");
//		int postalcode = Integer.parseInt(request.getParameter("postalcode"));
//		String address1 = request.getParameter("address1");
//		String address2 = request.getParameter("address2");
//		String address3 = request.getParameter("address3");
//		String address4 = request.getParameter("address4");
//		String address5 = request.getParameter("address5");
//		Date birth = new Date();
//		try {
//			 birth = sdFormat.parse(request.getParameter("birth"));
//		}catch(ParseException e) {
//			e.printStackTrace();
//		}
//		int age = Integer.parseInt(request.getParameter("age"));
//		String birthPlace = request.getParameter("birthPlace");
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		
		String inputId = request.getParameter("userId");
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
		String inputAge = request.getParameter("age");
		String inputBirthPlace = request.getParameter("birthPlace");
				
		InputAddressBook inputAddressBook = new InputAddressBook(inputId, inputName, inputGender, inputPhoneNumber, inputEmailAddress, inputPostalcode, inputAddress1, inputAddress2, inputAddress3, inputAddress4,  inputAddress5, inputBirth, inputAge, inputBirthPlace);
		
		//エラーチェック
		String errorMsg = inputAddressBook.errorCheck();
		if(!errorMsg.equals("")) {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", errorMsg);
			request.setAttribute("inputAddressBook", inputAddressBook);
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
			dispatcher.forward(request, response);
		}else {
			AddressBook addressBook = new AddressBook(inputAddressBook);
			
			UpdateLogic updateLogic = new UpdateLogic();
			
			if(updateLogic.execute(addressBook)) {
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateResult.jsp");
				dispatcher.forward(request, response);
			} else {
				//エラーメッセージをリクエストスコープに保存
				request.setAttribute("errorMsg", "修正に失敗しました");
				request.setAttribute("inputAddressBook", inputAddressBook);
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/update.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}
