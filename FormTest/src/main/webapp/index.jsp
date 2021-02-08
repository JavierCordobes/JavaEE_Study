
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
		<p>
			<label> Usuario<br> <input type="text" name="usuario">
			</label>
		</p>

		<p>
			<label>Password<br> <input type="password"
				name="password">
			</label>
		</p>

		<p>
			<label>Tecnologia</label> <input type="checkbox" name="tecnologia"
				value="java"><label for="cb1">Java</label> <input
				type="checkbox" name="tecnologia" value="net"><label
				for="cb2">.Net</label> <input type="checkbox" name="tecnologia"
				value="php"><label for="cb3">PHP</label>
		</p>

		<p>
			<label>Genero</label>
		<p>
			<input type="radio" name="genero" value="M"><label for="rad2">Mujer</label>
			<input type="radio" name="genero" value="H"><label for="rad1">Hombre</label>
			<input type="radio" name="genero" value="O"><label for="rad3">Otro</label><br>
		</p>


		<p>
			<label> Ocupación<br> <select name="ocupacion">
					<option value="" disabled selected>Seleccione Ocupación</option>
					<option value="Profesional">Profesional</option>
					<option value="Estudiante">Estudiante</option>
					<option value="Independiente">Independiente</option>
			</select>
			</label>
		</p>

		<p>
			<label>Libreta de Conducir<br> <select name="libreta"
				multiple>
					<option value="Moto">No</option>
					<option value="Moto">Moto</option>
					<option value="Auto">Auto</option>
					<option value="Profesional">Profesional</option>
			</select>
			</label>
		</p>

		<p>
			<label> Comentarios<br> <textarea name="comentario"
					rows="5" cols="40"></textarea>
			</label>
		</p>

		<p>
			<input type="reset" value="Limpiar" class="default">
		</p>
		<p>
			<input type="submit" value="Enviar" class="default" />
		</p>


	</form>

</body>
</html>