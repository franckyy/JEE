<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="inclusion.jspf" %>
<title>test session</title>
</head>
<body>
<jsp:include page="header.jsp">
	<jsp:param value="bonjour" name="message"/>
</jsp:include>
<h2><%= session.getAttribute("compteur") %></h2>
<h2>identifiant session :  <%= session.getId() %></h2>
<form action="IndexServlet" method="post">
	<input type="hidden" name="action" value="reinitialiser" />
	<input type="submit" value="Réinitialiser la session" />
</form>
</body>
</html>