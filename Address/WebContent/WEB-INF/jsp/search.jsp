<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.AddressBook, java.util.List" %>

<%
int pages = 1;
if(request.getAttribute("page") != null) {
	pages = (int) request.getAttribute("page");
}
%>

<%
//アプリケーションスコープに保存された住所録リストを取得
List<AddressBook> addressBookList = (List<AddressBook>) request.getAttribute("addressBookList");
%>

<%
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<%
//リクエストスコープに保存されたカウントを取得
double count = 0;
if(request.getAttribute("count") != null) {
	count = (int)request.getAttribute("count");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/logout.css">
<link rel="stylesheet" href="css/search.css">
<title>住所</title>
</head>
<body>

<jsp:include page="title.jsp"></jsp:include>
<h3>検索</h3>
<% if(errorMsg != null) { %>
<p><%= errorMsg  %></p>
<% } %>

<form action="SearchServlet">
氏名:<input type="text" name="nameSearch">
住所:<input type="text" name="addressSearch">
<input type="hidden" name="page" value=1>
<input type="submit" value="検索"><br>
</form>
<a href="ResisterServlet">新規登録</a>
<jsp:include page="logout.jsp"></jsp:include><br><br>
<table border="1">

<tr>
<th>id</th>
<th>氏名</th>
<th>性別</th>
<th>電話番号</th>
<th>メールアドレス</th>
<th>郵便番号</th>
<th>住所1</th>
<th>住所2</th>
<th>住所3</th>
<th>住所4</th>
<th>住所5</th>
<th>生年月日</th>
<th>年齢</th>
<th>出身地</th>
<th>修正</th>
<th>削除</th>
</tr>



<% if(addressBookList != null) {%>
	<%  String gender = "";%>
	<% for(AddressBook addressBook : addressBookList) {%>
		<% if(addressBook.getGender() == 1) {
			gender = "男性";
		 }else {
			 gender = "女性";
		 }
		 %>
		<tr>
		<td><%= addressBook.getId() %></td>
		<td><%= addressBook.getName() %></td>
		<td><%= gender %></td>
		<td><%= addressBook.getPhonenumber().toString() %></td>
		<td><%= addressBook.getEmailaddress() %></td>
		<td><%= addressBook.getPostalcode() %></td>
		<td><%= addressBook.getAddress1() %></td>
		<td><%= addressBook.getAddress2() %></td>
		<td><%= addressBook.getAddress3() %></td>
		<td><%= addressBook.getAddress4() %></td>
		<td><%= addressBook.getAddress5() %></td>
		<td><%= addressBook.getBirth() %></td>
		<td><%= addressBook.getAge() %></td>
		<td><%= addressBook.getBirthplace() %></td>

		<td>
		<form action="UpdateServlet" method="get">
		<input type="hidden" name="userId" value=<%= addressBook.getId() %>>
		<input type="hidden" name="name" value=<%= addressBook.getName() %>>
		<input type="hidden" name="gender" value=<%= addressBook.getGender() %>>
		<input type="hidden" name="phoneNumber" value=<%= addressBook.getPhonenumber() %>>
		<input type="hidden" name="emailAddress" value=<%= addressBook.getEmailaddress() %>>
		<input type="hidden" name="postalcode" value=<%= addressBook.getPostalcode() %>>
		<input type="hidden" name="address1" value=<%= addressBook.getAddress1() %>>
		<input type="hidden" name="address2" value=<%= addressBook.getAddress2() %>>
		<input type="hidden" name="address3" value=<%= addressBook.getAddress3() %>>
		<input type="hidden" name="address4" value=<%= addressBook.getAddress4() %>>
		<input type="hidden" name="address5" value=<%= addressBook.getAddress5() %>>
		<input type="hidden" name="birth" value=<%= addressBook.getBirth() %>>
		<input type="hidden" name="age" value=<%= addressBook.getAge() %>>
		<input type="hidden" name="birthPlace" value=<%= addressBook.getBirthplace() %>>
		<input type="submit" value="修正">
		</form>
		</td>

		<td>
		<form action="DeleteServlet" method="post">
		<input type="hidden" name="userId" value=<%= addressBook.getId() %>>
		<input type="submit" value="削除">
		</form>
		</td>

		</tr>
	<% } %>
<% } %>
</table>
<% if(pages > 1) { %>
	<form action="SearchServlet">
	<input type="hidden" name="page"  value=<%= pages %>>
	<input type="hidden" name="buttonAction" value="pref">
	<input type="submit" value="前の10件">
	</form>
<% } %>

<% if(pages < Math.ceil(count / 10)) { %>
	<form action="SearchServlet">
	<input type="hidden" name="page" value=<%= pages %>>
	<input type="hidden" name="buttonAction" value="next">
	<input type="submit" value="次の10件">
	</form>
<% } %>

</body>
</html>