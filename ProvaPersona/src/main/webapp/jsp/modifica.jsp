<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="modifica" method="POST">
<div>Nome:<input type="text" value="${p.nome}" name="nome"></div>
<div>Cognome:<input type="text" value="${p.cognome}" name="cognome"></div>
<div>eta:<input type="text" value="${p.eta}" name="eta"></div>
<div><input type="hidden" value="${p.id}" name="id"></div>
<div><input type="submit"></div>
</form>
</body>
</html>