<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/<%= request.getAttribute("style") %>" />
<script src="canvas.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Triangle</title>
</head>
<body>
<h2 id="titrepage">Triangle de taille : <%= request.getAttribute("dimension") %></h2><br/>

<table>
<%
int dimension = (int) request.getAttribute("dimension");
for(int ligne = 0; ligne < dimension; ligne++){ %>
<tr>
	<%for (int colonne = 0; colonne < dimension - ligne; colonne++) { 
		if(ligne == 0 || colonne == 0 || colonne == dimension - ligne - 1) {
		%>
			<td class="cellule">A</td>
		<%} else {%>
			<td class="cellule" id="bord">*</td>
		<%} %>
	<%} %>
</tr>
<%
} %>
</table>
<br/>

<br/><a href="index.html">Cliquez ici pour revenir au formulaire</a>
</body>
</html>