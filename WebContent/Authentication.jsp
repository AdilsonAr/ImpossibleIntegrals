<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user authentication</title>
</head>
<body style="text-align: center; background-color: blue;">

	<%
		boolean error = false;

		if (request.getAttribute("error") != null) {
			error = (boolean) request.getAttribute("error");
		}
	%>

	<h3 style="color: red; font-size: large;text-align: left;">
		<%
			pageContext.setAttribute("fal", false);
		%>
		<c:if test="${user}==${fal}">
			<a href="Home.html">/Home/</a>
		</c:if>
		<a href="ListResources.jsp">choose
			a integral/</a> <a href=User.jsp>User area/</a>
	</h3>

	<h3>you need to introduce your password to continue</h3>
	<br>
	<form action="Authentication" method="post">
		<input type="password" name="pass"><br>
		<%
		if(error)
		{
			out.print("<p style=\"color:red\">password is not correct</p>");
		}
		%>
		<br> <input type="submit" value="Enter"
			style="width: 160px; height: 40px; font-size: medium;">
	</form>

</body>
</html>