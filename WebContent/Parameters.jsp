<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solve</title>
</head>
<body style="background-color:blue; color:black;font: cursive;font-size:xx-large;text-align: center;">

<h3 style="color:red; font-size: large;text-align:left;">
<a href="Home.html">/Home/</a>
<a href="ListResources.jsp">Choose a new integral</a>
</h3><br> 
<hr>
<%
try
{
if(session.getAttribute("begin").equals(1))
{
String description=request.getParameter("description");
String name=request.getParameter("name");

session.setAttribute("description", description);
session.setAttribute("name", name);
session.setAttribute("begin", 0);
}}

catch(Exception e)
{
}

String path="images/"+session.getAttribute("name")+".png";
out.println("<img alt=\"integral image\" src=\""+path+"\">");
%>

<h5>
Give us your parameters to solve <%=session.getAttribute("name") %>!
</h5>
<form action="Results" method="get">
values of x variable: <input type="text" name="x">
<input type="submit" value=">>">
</form>
<%
if(request.getAttribute("ans")!=null)
{	
    String ans=request.getAttribute("ans").toString();
	out.print(ans);
}
%>
<hr>
</body>
</html>