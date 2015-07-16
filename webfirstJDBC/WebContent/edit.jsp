<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>edition client</title>
</head>
<body>
	<jsp:useBean id="client" type="com.loncoto.webfirstjdbc.beans.Client" scope="request"></jsp:useBean>
	<form action="ClientServlet" method="post">
		<input type="hidden" name="id" value='<jsp:getProperty name="client" property="id" />'>
		<input type="hidden" name="action" value="sauver" >
		nom : <input type="text" name="nom" value='<jsp:getProperty name="client" property="nom" />'><br/>
		email : <input type="text" name="email" value='<jsp:getProperty name="client" property="email" />'/><br/>
		solde : <input type="text" name="solde" value='<jsp:getProperty name="client" property="solde" />'/><br/>
		<input type="submit" value="sauver" /> 
	</form>
</body>
</html>