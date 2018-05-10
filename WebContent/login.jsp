<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/jmaster/AppServlet" method="post">
	ユーザー名:<input type ="text" name="name" /><br/>
	パスワード:<input type="password" name ="pass" /><br/>
	<input type ="hidden" name ="action" value="login" />
	<input type ="submit" value ="ログイン" />
</form>
