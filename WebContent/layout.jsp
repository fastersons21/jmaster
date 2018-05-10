<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHT News</title>
</head>
<body>
	<table>
		<tr>
			<td colspan="2"><%@ include file="/header.html" %></td>
		</tr>
		<tr>
			<td bgcolor="#AFEEEE"><jsp:include page= "/weather.jsp" />
			<td bgcolor="#FF99FF"><jsp:include page="/subject.jsp" />
		</td>
	</table>

</body>
</html>