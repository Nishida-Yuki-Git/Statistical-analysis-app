<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.List, model.RegResult" %>
<%
String errorMsg = (String) request.getAttribute("errorMsg");
List<RegResult> RegressionList = (List<RegResult>) request.getAttribute("RegressionList");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>統計解析アプリ</title>
  </head>
  <body>
	<h2>統計解析へようこそ</h2>
	<p><c:out value = "${userId}" />さんログイン中</p>
	<a href = "/myApp/LogoutServlet">ログアウトへ</a>

	<form action = "/myApp/RegCalcServlet" method = "post">
	  分析名称:<input type = "text" name = "analysisName"><br>
	  X列(数値は空白を設ける):<input type = "text" name = "xNumList"><br>
	  Y列(数値は空白を設ける):<input type = "text" name = "yNumList"><br>
	  <input type = "submit" value = "解析">
	</form>

	<% if(errorMsg != null) { %>
	  <p><%= errorMsg %></p>
	<% } %>
	<% for (RegResult regression : RegressionList) {%>
	  <p>分析名称:<%=regression.getAnalysisName() %></p>
	  <p>回帰直線:y = <%=regression.getStraightInc() %> + (<%=regression.getStraightIntercept() %>)</p>
	  <p>相関係数:<%=regression.getCorrelation() %></p>
	  <p>決定係数:<%=regression.getDetermination() %></p>
	<% } %>
  </body>
</html>








