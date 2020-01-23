<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Settings</title>
</head>
<body style="text-align: center;background-color: blue;">

<h3 style="color: red; font-size: large;text-align:left;">
		<a href="Home.html">/Home/</a> <a href="ListResources.jsp">choose
			a integral/</a> <a href=User.jsp>User area/</a><a href=Settings.jsp>Settings/</a>
	</h3>
	
<h3>
insert your new information
</h3>
<br><br>
<%
String me="";
boolean error=false;
if(request.getAttribute("error")!=null)
{
	error=(boolean)request.getAttribute("error");
	me=(String)request.getAttribute("me");
}

if(request.getParameter("parameter")!=null)
{
	String parameter=request.getParameter("parameter");
	session.setAttribute("action", parameter);
}

request.setAttribute("userName", "userName");
request.setAttribute("nickName", "nickName");
request.setAttribute("mail", "mail");
request.setAttribute("pass", "pass");
pageContext.setAttribute("tr", true);
pageContext.setAttribute("error", error);
%>

<c:if test="${action==userName}">
<form action="ParametersCollector" method="post">
Insert your new userName:&nbsp;&nbsp;<input type="text" name="value">

<input type="submit" value="Ok">
</form>
<c:if test="${error==tr}">
<p style="color: red">
<c:out value="${me}"></c:out>
</p>
</c:if>
</c:if>

<c:if test="${action==nickName}">
<form action="ParametersCollector" method="post">
Insert your new nickName:&nbsp;&nbsp;<input type="text" name="value">
<input type="submit" value="Ok">
</form>
<c:if test="${error==tr}">
<p style="color: red">
<c:out value="${me}"></c:out>
</p>
</c:if>
</c:if>

<c:if test="${action==mail}">
<form action="ParametersCollector" method="post">
Insert your new E-mail:&nbsp;&nbsp;<input type="text" name="value">
<input type="submit" value="Ok">
</form>
<c:if test="${error==tr}">
<p style="color: red">
<c:out value="${me}"></c:out>
</p>
</c:if>
</c:if>

<c:if test="${action==pass}">
<form action="ParametersCollector" method="post">
<table style="text-align: left;margin-left: 30%;">
<tr>
<td>Insert your new password:&nbsp;&nbsp;</td>
<td><input type="password" name="value"></td>
</tr>

<tr>
<td>Insert your new password again:&nbsp;&nbsp;</td>
<td><input type="password" name="passn2"></td>
</tr>

<tr>
<td><input type="submit" value="Ok"></td>
</tr>

</table>
</form>
<c:if test="${error==tr}">
<p style="color: red">
<c:out value="${me}"></c:out>
</p>
</c:if>
</c:if>

</body>
</html>