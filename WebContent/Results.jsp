<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
</head>
<body>

<%@include file="Parameters.jsp"%>

<%
double x=0;
try
{
	x=Double.parseDouble(request.getParameter("x"));
}

catch(Exception e)
{
	out.print("El dato ingresado no es valido :(");
}

out.print(x);
%>
</body>
</html>