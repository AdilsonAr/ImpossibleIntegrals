<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>

</head>
<body style="background-color: blue;text-align: center;">
<h3 style="color: red; font-size: large;text-align: left;">
		<%
			pageContext.setAttribute("fal", false);
		%>
		<c:if test="${user}==${fal}">
			<a href="Home.html">/Home/</a>
		</c:if>
		<a href="ListResources.jsp">choose a integral/</a>
	</h3>

<h3 style="text-align: center;">User area</h3>

<form action="SignIn.jsp">
<input type="submit" value="SignOut" style="width:80px;height:50px">
</form><br>

<form action="Authentication.jsp">
<input type="submit" value="Settings" style="width:80px;height: 50px;">
</form>
</body>
</html>