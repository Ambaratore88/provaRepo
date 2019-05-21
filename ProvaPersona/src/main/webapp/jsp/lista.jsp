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
<table>
<thead>
<th style="border:1px solid red" scope="col">Nome</th>
<th style="border:1px solid red" scope="col">Cognome</th>
<th style="border:1px solid red" scope="col">Eta</th>
</thead>
<c:forEach items="${persone}" var="item">
<tr>
<td style="border:1px solid red">${item.nome}</td>
<td style="border:1px solid red">${item.cognome}</td>
<td style="border:1px solid red">${item.eta}</td>

<td style="border:1px solid red"><form action="modificaId" method="POST">
	<input type="hidden" nome="modifica">
	<input type="hidden" name="id" value="${item.id}">
	<input class="inizio3" style="width:100%" type="submit" value="Modifica">
</form> 
</td><td style="border:1px solid red">
<form action="elimina" method="POST"">
	<input type="hidden" name="elimina">
	<input type="hidden" name="id" value="${item.id}">
	<input class="inizio3" type="submit" style="width:100%" name="elimina" value="Elimina" onclick="return ciao()">
</form> 
</td>

<td style="border:1px solid red"><form action="scheda" method="POST">
	<input type="hidden" name="scheda">
	<input type="hidden" name="id" value="${item.id}">
	<input class="inizio3" style="width:100%" type="submit" value="Scheda Anagrafica">
</form> 
</td>

</tr>
</c:forEach>
</table>
<a href="http://localhost:8080/ProvaPersona/index.jsp">Indietro</a>
</body>
</html>