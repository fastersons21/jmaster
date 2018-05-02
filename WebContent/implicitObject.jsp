<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String value = request.getParameter("name");
	session.setAttribute("name",value); //sessionに格納
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Use Implicit Object</title>
</head>
<body>

	指定されたパラメータ―の値は

	<%
		value = (String) session.getAttribute("name");
		out.println(value);//implicitは暗黙の意
	%>

	です。<%--javaファイルの埋め込み方
	基本的にｈｔｍｌやｃｓｓをつかって開発していくとServletだとデザイナーとのファイルがかぶってしまうためJSPは分けてつくることが出来るので有能 --%>

</body>
</html>