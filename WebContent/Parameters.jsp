<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solve</title>
</head>
<body style="background-color:blue; color:black;font: cursive;font-size:xx-large;">

<h3 style="color:red; font-size: large;">
<a href="Home.html">/Home/</a>
<a href="ListResources.jsp">Choose a new integral</a>
</h3>

<%
try
{
if(session.getAttribute("begin").equals(1))
{
String description=request.getParameter("description");
String name=request.getParameter("name");

session.setAttribute("description", description);
session.setAttribute("name", name);

session.removeAttribute("begin");
session.setAttribute("begin", 0);
}}

catch(Exception e)
{
	
}

%>

<table style="margin-left: 220px;margin-top: 100px">
<tr>
<th style="text-align: left;">
<h4>
Give us your parameters to solve <%=session.getAttribute("name") %>!
</h4>
</th>
</tr>

<tr>
<td style="text-align: left;">
<form action="Results" method="get">
values of x variable: <input type="text" name="x">
<input type="submit" value=">>">
</form>
</td>
</tr>

<tr>
<td style="text-align: left;">
<%
if(request.getAttribute("ans")!=null)
{
	
String ans=request.getAttribute("ans").toString();
if(ans!=null)
{
	out.print(ans);
}

}
%>
</td>
</tr>
</table>
</body>
</html>