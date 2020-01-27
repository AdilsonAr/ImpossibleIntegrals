<%@page import="com.classes.Commentary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.connections.MongoComment" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solve</title>
</head>
<body style="background-color:blue; color:black;font: cursive;font-size:xx-large;text-align: center;">

<h3 style="color:red; font-size: large;text-align:left;">
<%
pageContext.setAttribute("tr", true);
%>
<c:if test="${user != tr}">
<a href="Home.html">/Home/</a>
</c:if>
<a href="ListResources.jsp">Choose a new integral</a>
</h3>
<hr>
<%
double valueX =0;
boolean value=false;
if (request.getAttribute("x")!=null)
{
	value=true;
	valueX=(Double) request.getAttribute("x");
}
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
values of x variable: <input type="text" name="x"
<%if(value) out.print("value=\" "+valueX+"\"");%>
>
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

<%
ArrayList <Commentary> list=new ArrayList(); 
String integral =(String)session.getAttribute("name");
MongoComment mongo=new MongoComment();
list=mongo.read(integral);
pageContext.setAttribute("list", list);
%>

<textarea cols="100" readonly="readonly" rows="10" style="color:blue;background-color:aqua;">
<c:forEach var="current" items="${list}">
#${current.name}
${current.text}
</c:forEach>
</textarea>

<c:if test="${user}">
<br>
<form action="Add" method="post">
<textarea rows="2" cols="100" name="com"></textarea><br>
<input type="submit" value="Send">
</form>
</c:if>

</body>
</html>