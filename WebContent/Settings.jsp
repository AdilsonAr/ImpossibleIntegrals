<%@page import="com.classes.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User settings</title>
</head>
<body style="background-color: blue;text-align: center;">

	<h3 style="color: red; font-size: large;text-align:left;">
		<%
			pageContext.setAttribute("fal", false);
		%>
		<c:if test="${user}==${fal}">
			<a href="Home.html">/Home/</a>
		</c:if>

		<a href="ListResources.jsp">choose
			a integral/</a> <a href=User.jsp>User area/</a>
	</h3>

	<p style="font-size:large;">
	User settings :)
	</p>
	
	<%
	User user=(User)session.getAttribute("userTemp");
	session.setAttribute("modified", false);
	%>
	<table style="margin-left: 35%;text-align: left;">
		<tr>
		<td>userName:</td>
			<td><input type="text" name="userName"
				readonly value=<%=user.getUserName()%>>
			</td>

			<td>
				<form action="SettingsDetails.jsp">
					<input type="hidden" name="parameter" value="userName"> <input
						type="submit" value="Edit">
				</form>
			</td>
		</tr>

		<tr>
		<td>NickName:</td>
			<td><input type="text" name="nickName"
				readonly value=<%=user.getUserNickname()%>>
			</td>

			<td>
				<form action="SettingsDetails.jsp">
					<input type="hidden" name="parameter" value="nickName"> <input
						type="submit" value="Edit">
				</form>
			</td>
		</tr>

		<tr>
		<td>E-mail:</td>
			<td><input type="text" name="e-mail"
				readonly value=<%=user.getE_mail()%>>
			</td>

			<td>
				<form action="SettingsDetails.jsp">
					<input type="hidden" name="parameter" value="mail"> <input
						type="submit" value="Edit">
				</form>
			</td>
		</tr>
		
		<tr>
		<td>Password:</td>
			<td><input type="text" name="password"
				readonly value=Password>
			</td>

			<td>
				<form action="SettingsDetails.jsp">
					<input type="hidden" name="parameter" value="pass"> <input
						type="submit" value="Edit">
				</form>
			</td>
		</tr>
		
			</table>
			<br>
			<form action="UpdateUser">
			<input type="submit" value="Finish">
			</form>

</body>
</html>