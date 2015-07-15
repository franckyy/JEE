<%@page import="java.util.List"%>
<%@page import="com.loncoto.webfirstjdbc.beans.Client"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
							<form action="clientServlet" method="post">
								
								<input type="hidden" name="id" value=`<%= c.getId() %>`/>
								<input type="hidden" name="action" value=`editer` />
								<input type="submit" value="Edition" />
							</form>
						</td>
					</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>