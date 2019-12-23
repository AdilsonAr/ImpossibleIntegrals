<%@page import="com.classes.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
boolean error =false;

User user = new User();
boolean errorBlank=false;
boolean errorPass=false;
boolean errorE_mail=false;
boolean errorUser=false;

try
{
	error=(boolean)request.getAttribute("error");
}

catch(Exception e)
{
}

if(error)
{
	user=(User)request.getAttribute("user");
	errorBlank=(boolean)request.getAttribute("blank");
	errorPass=(boolean)request.getAttribute("pass");
	errorE_mail=(boolean)request.getAttribute("e_mail");
	errorUser=(boolean)request.getAttribute("userNickname");
	
	String userNickname=user.getUserNickname();
	String userName=user.getUserName();
	String e_mail=user.getE_mail();
	String pass=user.getPass();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body style="background-color:blue;text-align:center;">

<h3 style="color:red;font-size: large;text-align: left;">
<a href="Home.html">/Home</a>
<a href="SignIn.jsp">/Sign in</a>
</h3>

<h3 style="margin-top:130px;color:white;">Insert your information to sign up in this site</h3><br>
<form action="SignUp" method="post">

<table style="text-align:left;margin-left: 435px">
<tr>
<td>
Name:
</td>
<td>
<input type="text" name="userName" <%
if(error) out.print("value=\""+user.getUserName()+"\"");
%>>
</td>
</tr>

<tr>
<td>
User:
</td>
<td>
<input type="text" name="userNickname"<%
if(errorUser)out.print("style=\"background-color:red;\"");
%>>

<%
if(errorUser)
{
	out.println("<p style=\"color:red\">This user already exists</p>");
}
%>

</td>
</tr>

<tr>
<td>
E-mail:
</td>
<td>
<input type="text" name="e_mail"<%
if(errorE_mail)out.print("style=\"background-color:red;\"");
%>>

<%
if(errorE_mail)
{
	out.println("<p style=\"color:red\">this e_mail has already been used for an account</p>");
}
%>
</td>
</tr>

<tr>
<td>
Password:
</td>
<td>
<input type="password" name="pass"<%
if(errorPass)out.print("style=\"background-color:red;\"");
%>>
</td>
</tr>
<tr>
<td>
write your password again: 
</td>
<td>
<input type="password" name="pass2"<%if(errorPass)out.print("style=\"background-color:red;\"");%>>

<%
if(errorPass)
{
	out.println("<p style=\"color:red\">passwords are different</p>");
}
%>
</td>
</tr>
</table>
<%
if(errorBlank)
{
	out.println("<p style=\"color:red\">all fields are required</p>");
}
else
{
	out.print("<br><br>");
}
%>
<input type="submit" value="Sign Up" style="width: 160px; height: 40px;font-size: medium;">
</form>
</body>
</html>