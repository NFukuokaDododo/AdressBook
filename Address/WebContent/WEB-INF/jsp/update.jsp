<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.InputAddressBook, java.text.SimpleDateFormat" %>
    
<%
//リクエストスコープに保存されたインスタンスを取得
InputAddressBook inputAddressBook = (InputAddressBook) request.getAttribute("inputAddressBook");
%>

<%
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/errorMsg.css">
<title>Iドラクエ12</title>
</head>

<body>
<jsp:include page="title.jsp"></jsp:include>
<h3>修正</h3>

<% if(errorMsg != null) { %>
<p class="errorMsg"><%= errorMsg  %></p>
<% } %>

<form action="UpdateServlet" method="post">
<table border="1">

<tr>
<th>id</th><td><input type="hidden" name="userId" value="<%= inputAddressBook.getId() %>"><%= inputAddressBook.getId() %></td>
</tr>

<tr>
<th>氏名</th><td><input type="text" name="name" value="<%= inputAddressBook.getName() %>"></td>
</tr>

<tr>
<th>性別</th>
<td>
<select name="gender">
<option value="1" <%= inputAddressBook != null && inputAddressBook.getGender().equals("1") ? "selected" : ""  %>>男性</option>
<option value="2" <%= inputAddressBook != null && inputAddressBook.getGender().equals("2") ? "selected" : ""  %>>女性</option>
</select>
</td>
</tr>

<tr>
<th>電話番号</th><td><input type="text" name="phoneNumber" value="<%= inputAddressBook.getPhonenumber() %>"></td>
</tr>

<tr>
<th>メールアドレス</th><td><input type="text" name="emailAddress" value="<%= inputAddressBook.getEmailaddress() %>"></td>
</tr>

<tr>
<th>郵便番号</th><td><input type="text" name="postalcode" value="<%= inputAddressBook.getPostalcode() %>"></td>
</tr>

<tr>
<th>住所1</th>
<td>
<select name="address1">
<option value="北海道" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("北海道") ? "selected" : ""  %>>北海道</option>
<option value="青森県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("青森県") ? "selected" : ""  %>>青森県</option>
<option value="岩手県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("岩手県") ? "selected" : ""  %>>岩手県</option>
<option value="宮城県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("宮城県") ? "selected" : ""  %>>宮城県</option>
<option value="秋田県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("秋田県") ? "selected" : ""  %>>秋田県</option>
<option value="山形県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("山形県") ? "selected" : ""  %>>山形県</option>
<option value="福島県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("福島県") ? "selected" : ""  %>>福島県</option>
<option value="茨城県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("茨城県") ? "selected" : ""  %>>茨城県</option>
<option value="栃木県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("栃木県") ? "selected" : ""  %>>栃木県</option>
<option value="群馬県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("群馬県") ? "selected" : ""  %>>群馬県</option>
<option value="埼玉県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("埼玉県") ? "selected" : ""  %>>埼玉県</option>
<option value="千葉県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("千葉県") ? "selected" : ""  %>>千葉県</option>
<option value="東京都" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("東京都") ? "selected" : ""  %>>東京都</option>
<option value="神奈川県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("神奈川県") ? "selected" : ""  %>>神奈川県</option>
<option value="新潟県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("新潟県") ? "selected" : ""  %>>新潟県</option>
<option value="富山県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("富山県") ? "selected" : ""  %>>富山県</option>
<option value="石川県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("石川県") ? "selected" : ""  %>>石川県</option>
<option value="福井県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("福井県") ? "selected" : ""  %>>福井県</option>
<option value="山梨県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("山梨県") ? "selected" : ""  %>>山梨県</option>
<option value="長野県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("長野県") ? "selected" : ""  %>>長野県</option>
<option value="岐阜県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("岐阜県") ? "selected" : ""  %>>岐阜県</option>
<option value="静岡県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("静岡県") ? "selected" : ""  %>>静岡県</option>
<option value="愛知県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("愛知県") ? "selected" : ""  %>>愛知県</option>
<option value="三重県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("三重県") ? "selected" : ""  %>>三重県</option>
<option value="滋賀県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("滋賀県") ? "selected" : ""  %>>滋賀県</option>
<option value="京都府" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("京都府") ? "selected" : ""  %>>京都府</option>
<option value="大阪府" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("大阪府") ? "selected" : ""  %>>大阪府</option>
<option value="兵庫県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("兵庫県") ? "selected" : ""  %>>兵庫県</option>
<option value="奈良県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("奈良県") ? "selected" : ""  %>>奈良県</option>
<option value="和歌山県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("和歌山県") ? "selected" : ""  %>>和歌山県</option>
<option value="鳥取県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("鳥取県") ? "selected" : ""  %>>鳥取県</option>
<option value="島根県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("島根県") ? "selected" : ""  %>>島根県</option>
<option value="岡山県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("岡山県") ? "selected" : ""  %>>岡山県</option>
<option value="広島県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("広島県") ? "selected" : ""  %>>広島県</option>
<option value="山口県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("山口県") ? "selected" : ""  %>>山口県</option>
<option value="徳島県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("徳島県") ? "selected" : ""  %>>徳島県</option>
<option value="香川県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("香川県") ? "selected" : ""  %>>香川県</option>
<option value="愛媛県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("愛媛県") ? "selected" : ""  %>>愛媛県</option>
<option value="高知県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("高知県") ? "selected" : ""  %>>高知県</option>
<option value="福岡県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("福岡県") ? "selected" : ""  %>>福岡県</option>
<option value="佐賀県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("佐賀県") ? "selected" : ""  %>>佐賀県</option>
<option value="長崎県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("長崎県") ? "selected" : ""  %>>長崎県</option>
<option value="熊本県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("熊本県") ? "selected" : ""  %>>熊本県</option>
<option value="大分県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("大分県") ? "selected" : ""  %>>大分県</option>
<option value="宮崎県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("宮崎県") ? "selected" : ""  %>>宮崎県</option>
<option value="鹿児島県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("鹿児島県") ? "selected" : ""  %>>鹿児島県</option>
<option value="沖縄県" <%= inputAddressBook != null && inputAddressBook.getAddress1().equals("沖縄県") ? "selected" : ""  %>>沖縄県</option>
</select>
</td>
</tr>

<tr>
<th>住所2</th><td><input type="text" name="address2" value="<%= inputAddressBook.getAddress2() %>"></td>
</tr>

<tr>
<th>住所3</th><td><input type="text" name="address3" value="<%= inputAddressBook.getAddress3() %>"></td>
</tr>

<tr>
<th>住所4</th><td><input type="text" name="address4" value="<%= inputAddressBook.getAddress4() %>"></td>
</tr>

<tr>
<th>住所5</th><td><input type="text" name="address5" value="<%= inputAddressBook.getAddress5() %>"></td>
</tr>

<tr>
<th>生年月日</th><td><input type="text" name="birth" value="<%= inputAddressBook.getBirth() %>"></td>
</tr>

<tr>
<th>年齢</th><td><input type="hidden" name="age" value="<%= inputAddressBook.getAge() %>"><%= inputAddressBook.getAge() %></td>
</tr>

<tr>
<th>出身地</th><td><input type="text" name="birthPlace" value="<%= inputAddressBook.getBirthplace() %>"></td>
</tr>


</table>

<input type="submit" value="登録">
</form>

<a href="ReturnServlet">戻る</a><br>
<jsp:include page="logout.jsp"></jsp:include>
</body>
</html>