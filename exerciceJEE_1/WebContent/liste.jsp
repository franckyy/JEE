<%@ page import="com.loncoto.exercice.beans.Article"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/>
<%@ include file="inclusions.jspf" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des articles</title>
</head>
<body>
<h1>LISTE DES ARTICLES</h1>
<div class="CSSTableGenerator">
<table border="1">
	<tr>
		<th><a href="ServletArticle" >Libellé</a></th>
		<th><a href="ServletArticle/prix">Prix</a></th>
		<th><a href="ServletArticle/poids">Poids</a></th>
		<th>Actions</th>
	</tr>
		<c:forEach items="${requestScope.articles}" var="article">
			<tr>
				<td><c:out value="${article.libelle}"/></td>
				<td><c:out value="${article.prix}"/></td>
				<td><c:out value="${article.poids}"/></td>
				<td>
					<form action="ServletArticle" method="post">
						<input type="hidden" name="id" value="<c:out value="${article.id}"/>" />
						<input type="hidden" name="action" value="editer" />
						<input type="submit" value="Editer" />
					</form>
					<form action="ServletArticle" method="post">
						<input type="hidden" name="id" value="<c:out value="${article.id}"/>" />
						<input type="hidden" name="action" value="supprimer" />
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</c:forEach>
</table>
	
<%-- 	<table border="1">
		<tr>
			<th>Libellé</th>
			<th>Prix</th>
			<th>Poids</th>
			<th>Actions</th>
		</tr>
		<% 
		List<Article> articles = (List<Article>)request.getAttribute("articles"); 
		for(Article article : articles){
		%>
		<tr>
			<td><%= article.getLibelle() %></td>
			<td><%= article.getPrix() %></td>
			<td><%= article.getPoids() %></td>
			<td>
				<form action="ServletArticle" method="post">
					<input type="hidden" name="id" value="<%= article.getId() %>" />
					<input type="hidden" name="action" value="editer" />
					<input type="submit" value="Editer" />
				</form>
				<form action="ServletArticle" method="post">
					<input type="hidden" name="id" value="<%= article.getId() %>" />
					<input type="hidden" name="action" value="supprimer" />
					<input type="submit" value="Supprimer" />
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table> --%>
	<br/>
	<form action="ServletArticle" method="post">
		<input type="hidden" name="action" value="creer" />
		<input type="submit" value="Nouvel article" />
	</form>
	<br />
</div>
</body>
</html>