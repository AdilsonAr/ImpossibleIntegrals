<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
session.setAttribute("user", false);
boolean error=false;
try
{	
	error=(boolean)request.getAttribute("error");
}
catch(Exception e){	
}

Cookie [] listCookies=request.getCookies();
String user="";
for(Cookie current:listCookies)
{
	if(current.getName().equalsIgnoreCase("ImpossibleIntegralsUser"))
	{
		user=current.getValue();
	}
}
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>

<body style="text-align: center;background-color: blue;">
<h3 style="color:red;font-size: large;text-align: left;">
<a href="Home.html">/Home</a>
</h3>
<br><br><br>
<img style="width: 180px;height: 180px;" alt="User icon" src="images/User.jpg">
<br><br>

<form action="SignIn" method="post">
Nickname:&nbsp;<input type="text" name="user"<%
if(!user.isBlank())
{
	out.print("value=\""+user+"\"");
}
%>><br><br>
Password:&nbsp;&nbsp;<input type="password" name="pass"><br><br>
<input type="submit" value="Sign in" style="width: 160px; height: 40px;font-size: medium;">
</form>

<%
if(error)
{
	out.println("<p style=\"color:red\">The information is not correct</p>");
}
else
{
	out.print("<br>");
}
%>

<form action="SignUp.jsp" method="get">
<input type="submit" value="Sign up?" style="width: 160px; height: 40px;font-size: medium;">
</form>
</body>

</html>