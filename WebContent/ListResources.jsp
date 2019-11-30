<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.connections.DAOIntegralObject"%>
<%@page import="com.classes.IntegralObject"%>
<%@page import="com.classes.Integral"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choose a integral</title>
</head>
<body style="background-color:blue;">
<br>
<h2 style="text-align:center">
here you have the list of integrals available at this time
</h2><br>
<%!
DAOIntegralObject dao = new DAOIntegralObject();
ArrayList<IntegralObject> lista= dao.read();
String action="Parameters.jsp";
%>

<%
out.println("<table>");
for(IntegralObject current:lista)
{
	Class<?> element=Class.forName("com.integrals."+current.getClassName());
	Object element2=element.newInstance();
	
	String path="C:/Users/KGB/Desktop/Java/Workspace/ImpossibleIntegrals/src/com/images/";
	path+=current.getClassName()+".png";
	
	Method getName =element.getMethod("getName");
	String description=(String) getName.invoke(element2);
	
	out.println("<tr style=\"height: 100px;\">");
	out.println("<td>");
	out.println("<form action=\""+action+"\" method=\"get\">");
	out.println("&nbsp;&nbsp;&nbsp;<input type=\"image\" src=\"" + path + "\" alt=\"Integral image\">");
	out.println("<input type=\"hidden\" name=\"name\" value=\""+current.getClassName()+"\">");
	out.println("<input type=\"hidden\" name=\"description\" value=\""+description+"\">");
	out.println("</form>");	
	out.println("</td>");
	
	out.println("<td>");
	out.println("&nbsp;&nbsp;&nbsp;Are you going to use "+current.getDescription()+"?");
	out.println("</td>");
	out.println("</tr>");
}
out.println("</table>");
%>

</body>
</html>