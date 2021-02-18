<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>統計解析アプリ</title>
  </head>
  <body>
	<p>ようこそ<c:out value = "${userId}" />さん</p>
	<a href = "/myApp/RegCalcServlet">統計解析へ</a>
  </body>
</html>