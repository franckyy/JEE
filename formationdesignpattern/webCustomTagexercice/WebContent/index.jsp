<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="hell" uri="/WEB-INF/custom.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<hell:hello/>

<hr/>
	<hell:SelectGenerator keyProperty="id" items="articles" valueProperty="libelle"/>
<hr/>
	<hell:AffichMessage bold="true" message="Coucou je suis gras"/>
<br/>
	<hell:AffichMessage bold="false" message="Coucou, je ne suis pas gras"/>
</body>
</html>