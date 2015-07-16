<%@page import="java.util.List"%>
<%@page import="com.loncoto.webfirstjdbc.beans.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<LINK rel="stylesheet" type="text/css" href="css/style.css">
<title>Liste des clients</title>
</head>
<body>
<br/>
<h1><u>LISTE DES CLIENTS VIP</u></h1>
<br/>
	<div class="CSSTableGenerator" >
		<table border="1">
			<tr>
				<th>nom</th>
				<th>email</th>
				<th>actions</th>
			</tr>
			<%
				List<Client> clients = (List<Client>) request.getAttribute("clients");
			
				for(Client c : clients){
			%>
					<tr>
						<td><%= c.getNom() %></td>
						<td id="email"><u><%= c.getEmail() %></u></td>
						<td>
							<form action="ClientServlet" method="post">
								<input type="hidden" name="id" value="<%= c.getId() %>"/>
								<input type="hidden" name="action" value="editer" />
								<input type="submit" value="Edition" />
							</form><form action="ClientServlet" method="post">
								<input type="hidden" name="id" value="<%= c.getId() %>"/>
								<input type="hidden" name="action" value="supprimer" />
								<input type="submit" value="Supprimer" />
							</form>
						</td>
					</tr>
			<%
				}
			%>
		</table>
		<br/>
		<form action="ClientServlet" method="post">			
			<input type="hidden" name="action" value="creer" />
			<input type="submit" value="Nouveau client friqué" />
		</form>
		<br/>
	</div>
</body>
</html>