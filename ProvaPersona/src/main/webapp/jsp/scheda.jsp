<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><span>nome:${p.nome}</span></h1>
<h1><span>cognome:${p.cognome}</span></h1>
<h1><span>eta:${p.eta}</span></h1>
<form action="ListaPersona" method="GET">
<input type="submit" value="Indietro">

</form>
</body>
</html>