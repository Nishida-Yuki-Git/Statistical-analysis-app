<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
  <title>統計解析アプリ</title>
  </head>
  <body>
    <h2>ユーザー登録</h2>
    <form action = "/myApp/EntryServlet" method = "post">
      ユーザーID:<input type = "text" name = "userId"><br>
      パスワード:<input type = "password" name = "pass"><br>
      メールアドレス:<input type = "text" name = "mail"><br>
      姓名:<input type = "text" name = "name"><br>
      年齢:<input type = "number" name = "age"><br>
      <input type = "submit" value = "ユーザー登録">
    </form>
  </body>
</html>