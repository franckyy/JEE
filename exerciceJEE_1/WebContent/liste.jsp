<%@ page import="com.loncoto.exercice.beans.Article"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des articles</title>
</head>
<body>
<h1>LISTE DES ARTICLES</h1>
<div>
	<table border="1">
		<tr>
			<th>Libellé</th>
			<th>Prix</th>
			<th>Poids</th>
		</tr>
		<% 
		List<Article> articles = (List<Article>)request.getAttribute("articles"); 
		for(Article article : articles){
		%>
			<td><%= article.getLibelle() %></td>
			<td><%= article.getPrix() %></td>
			<td><%= article.getPoids() %></td>
		<%
		}
		%>
	</table>
</div>
</body>
</html>