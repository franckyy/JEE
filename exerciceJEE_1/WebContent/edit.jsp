<%@ page import="com.loncoto.exercice.beans.Article"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ include file="inclusions.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des articles</title>
</head>
<body>
<h1>LISTE DES ARTICLES</h1>
<jsp:useBean id="articleEdit"
			type="com.loncoto.exercice.beans.Article"
			scope="request">
</jsp:useBean>
<div class="CSSTableGenerator">
<table border="1">
	<tr>
		<th>Libellé</th>
		<th>Prix</th>
		<th>Poids</th>
	</tr>
		<tr>
			<td><jsp:getProperty name="articleEdit" property="libelle"/></td>
			<td><jsp:getProperty name="articleEdit" property="prix"/></td>
			<td><jsp:getProperty name="articleEdit" property="poids"/></td>
		</tr>
</table>
<br/>
<form action="ServletArticle" method="post">
	<input type="hidden" name="action" value="validerEdition" />
	<input type="submit" value="Valider" />
</form>
<br />
</div>
</body>
</html>