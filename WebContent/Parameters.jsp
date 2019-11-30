<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Solve</title>
</head>
<body style="background-color:blue; color:black;text-align:center;font: cursive;font-size:xx-large;">

<h3>

Give us your parameters to solve <%=request.getParameter("description") %>!
</h3><hr>
<form action="Results.jsp" method="get">

values of x variable: <input type="text" name="x">
<input type="submit" value=">>">
</form>
<hr>

</body>
</html>