
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="Stylesheet" type="text/css" href="recursos/estilos.css">
<script type="text/javascript" src="recursos/funciones.js"></script>

<title>Formulario</title>
</head>
<body>

	<form name="form1" action="formServ" method="post"
		 onsubmit="return validarForma(this)">

		<input type="hidden" name="oculto" value="valorOculto">

		<table width="500" id="enfasis-columna">
			<caption>Formulario Registro Datos</caption>
			<tr>
				<td class="columna">Usuario:</td>
				<td><input class="default" type="text" name="usuario"
					 onfocus="this.select()"></td>
			</tr>
			<tr>
				<td class="columna">Password:</td>
				<td><input class="default" type="password" name="password"
					onfocus="this.select()"></td>
			</tr>
			<tr>
				<td class="columna">Tecnologia:</td>
				<td>Java <input type="checkbox" name="tecnologia" value="java">&nbsp;&nbsp;&nbsp;
					.Net <input type="checkbox" name="tecnologia" value="net">&nbsp;&nbsp;&nbsp;
					PHP <input type="checkbox" name="tecnologia" value="php">&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td class="columna">Genero:</td>
				<td>Hombre <input type="radio" name="genero" value="H">&nbsp;&nbsp;&nbsp;
					Mujer <input type="radio" name="genero" value="M">&nbsp;&nbsp;&nbsp;
					Otro <input type="radio" name="genero" value="O">&nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td class="columna">Ocupación:</td>
				<td><select name="ocupacion" class="default">
					<option value="0">Seleccione Profesion</option>
						<option value="1">Profesional</option>
						<option value="2">Estudiante</option>
						<option value="3">Independiente</option>
				</select></td>
			</tr>
			<tr>
				<td class="columna">Libreta de Conducir:</td>
				<td><select name="libreta" multiple class="default">
				
						<option value="Moto">Moto</option>
						<option value="Auto">Auto</option>
						<option value="Profesional">Profesional</option>
				</select></td>
			</tr>
			<tr>
				<td class="columna">Comentarios:</td>
				<td><textarea name="comentario" rows="2" cols="30"
						class="default" onfocus="this.select()" Escribir un texto></textarea>
				</td>
			</tr>
			<tr style="text-align: center">

				<td><input type="reset" value="Limpiar" class="default"></td>
				<td><input type="submit" value="Enviar" class="default" /></td>
			</tr>
		</table>

	

	</form>
</body>
</html>