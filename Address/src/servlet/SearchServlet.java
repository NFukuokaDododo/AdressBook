package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddressBook;
import model.GetAddressBookListLogic;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String nameSearch = request.getParameter("nameSearch");
		String addressSearch = request.getParameter("addressSearch");
		int page = Integer.parseInt(request.getParameter("page"));
		String buttonAction = "";
		if(request.getParameter("buttonAction") != null) {
			buttonAction = request.getParameter("buttonAction");
		}

		//入力値チェック
		if((nameSearch == null || nameSearch == "") && (addressSearch == null || addressSearch == "")) {
			//addressbookテーブルからすべてのデータを取得
			GetAddressBookListLogic getAddressBookListLogic = new GetAddressBookListLogic();
			
			
			if(buttonAction.equals("pref")) {
				page--;
			}else if(buttonAction.equals("next")) {
				page++;
			}
			List<AddressBook> addressBookList = getAddressBookListLogic.execute(page);
			request.setAttribute("count", getAddressBookListLogic.executeCount());
			request.setAttribute("addressBookList", addressBookList);
			request.setAttribute("page", page);
		}else if((nameSearch != null && nameSearch != "") && (addressSearch == null || addressSearch == "")) {
			//addressbookテーブルから名前の合致したデータを取得
			GetAddressBookListLogic getAddressBookListLogic = new GetAddressBookListLogic();
			List<AddressBook> addressBookList = getAddressBookListLogic.executeName(nameSearch);
			request.setAttribute("addressBookList", addressBookList);
		}else if((nameSearch == null || nameSearch == "") && (addressSearch != null && addressSearch != "")) {
			//addressbookテーブルから住所の合致したデータを取得
			GetAddressBookListLogic getAddressBookListLogic = new GetAddressBookListLogic();
			List<AddressBook> addressBookList = getAddressBookListLogic.executeAddress(addressSearch);
			request.setAttribute("addressBookList", addressBookList);
			request.setAttribute("pages", page + 1);
		}else if((nameSearch != null && nameSearch != "") && (addressSearch != null && addressSearch != "")) {
			//addressbookテーブルから条件に合致したデータを取得
			GetAddressBookListLogic getAddressBookListLogic = new GetAddressBookListLogic();
			List<AddressBook> addressBookList = getAddressBookListLogic.execute(nameSearch, addressSearch);
			request.setAttribute("addressBookList", addressBookList);
		}
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}
}
