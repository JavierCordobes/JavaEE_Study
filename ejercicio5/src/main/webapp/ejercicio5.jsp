<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="ejercicio5.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Ejercicio 5</title>
</head>
<body>
	<f:view>
		<h1>Ejercicio 5</h1>
		<p>Armar una página Web JSP con el siguiente formulario, que vaya
			cargando líneas en la sesión y a la vez muestre las líneas que están
			cargadas.</p>
		<fieldset>
			<legend>Nuevo</legend>
			<form action="AgregarLinea" method="post">
				<table>
					<tr>
						<td>Codigo</td>
						<td>Nombre</td>
						<td>Cantidad</td>
					
						<td>
							&nbsp;
						</td>
					</tr>
					<tr>
						<td><input  type="text" name="codigo" required/></td>
						<td><input type="text" name="nombre" required/></td>
						<td><input type="text" name="cantidad" required/></td>
						<td><input type="submit" value="Agregar" /></td>

					</tr>
				</table>
			</form>
		</fieldset>

		<%
		if (session.getAttribute("LISTA") != null) {
		%>
		<fieldset>
			<legend>Actuales</legend>
			<table border="1">
				<tr>
					<td>Codigo</td>
					<td>Nombre</td>
					<td>Cantidad</td>
				</tr>
				<%
				List<Linea> lista = (List<Linea>)session.getAttribute("LISTA");
				for (Linea l : lista) {
				%>
				<tr>
					<td><%=l.getCodigo()%></td>
					<td><%=l.getNombre()%></td>
					<td><%=l.getCantidad()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</fieldset>
		<%
		}
		%>

	</f:view>
</body>
</html>