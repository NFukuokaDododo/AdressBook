<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
String logoutMsg = (String) request.getAttribute("logoutMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="sample.js"></script>
<link rel="stylesheet" href="css/sample.css">
<title>住所</title>
</head>
<body id="index">
<h1 id="title">住所登録管理</h1>
<% if(errorMsg != null) { %>
<p class="errorMsg"><%= errorMsg  %></p>
<% } %>
<% if(logoutMsg != null) { %>
<p><%= logoutMsg  %></p>
<% } %>
<form action="LoginServlet" method="post">
ユーザーID:<input type="text" id="userId" class="login" name="userId"><br>
パスワード:<input type="password" id="password"  class="login" name="password"><br>
<input type="submit" id="loginBtn" value="ログイン">
</form>
<p id="indexId" class="indexClass">JavaScript</p>
<input type="button" id="btn" value="クリック" onClick="btnClick()">
<input type="button" id="btn" value="クリック2" onClick="btnClick2()">
<input type="button" id="btn3" value="クリック3" onClick="btnClick3()">
</body>
</html>