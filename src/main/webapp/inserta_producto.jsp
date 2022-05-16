<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
@import
	url(https://fonts.googleapis.com/css?family=Roboto:400,300,600,400italic)
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-font-smoothing: antialiased;
	-moz-font-smoothing: antialiased;
	-o-font-smoothing: antialiased;
	font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
}

body {
	font-family: "Roboto", Helvetica, Arial, sans-serif;
	font-weight: 100;
	font-size: 12px;
	line-height: 30px;
	color: #777;
	background: #E9F4F6;
}

main {
	width: 90%;
}

.text {
	height: 60%;
	width: 60%;
	border-radius: 10px;
	background: #017366;
	box-shadow: 0px 4px 20px rgba(0, 0, 0, 0.25);
	position: absolute;
	top: 40%;
	left: 5%;
	z-index: 0;
}

.text p {
	color: #fff;
	font-size: 14px;
	padding: 10% 70% 30% 5%;
	padding-right: 70%;
}

.container {
	max-width: 400px;
	width: 100%;
	margin: 0 auto;
	position: relative;
	z-index: 1;
}

.container::before {
	content: '';
	height: 90%;
	width: 95%;
	border-radius: 10px;
	background: #fff;
	position: absolute;
	top: -2%;
	left: 8%;
	z-index: -1;
}

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"],
	#contact input[type="url"], #contact select#profissao, #contact button[type="submit"]
	{
	font: 400 12px/16px "Roboto", Helvetica, Arial, sans-serif;
}

#contact {
	right: 10px;
	top: 10px;
	background: #FFFFFF;
	padding: 25px;
	margin: 150px 0;
	border-radius: 10px;
	box-shadow: 5px 10px 30px 1px rgba(0, 0, 0, 0.15);
}

#contact h3 {
	display: block;
	font-size: 30px;
	font-weight: 600;
	margin-bottom: 10px;
	color: #1C1C1C;
}

#contact h4 {
	margin: 0px 0 15px;
	display: block;
	font-size: 13px;
	font-weight: 400;
	color: #CCD0CF;
}

fieldset {
	border: medium none !important;
	margin: 0 0 10px;
	min-width: 100%;
	padding: 0;
	width: 100%;
}

#contact input[type="text"], #contact input[type="email"], #contact input[type="tel"],
	#contact input[type="url"], #contact select#profissao {
	width: 100%;
	border: 1px solid #ccc;
	background: #FFF;
	margin: 0 0 5px;
	padding: 10px;
	border: none;
	color: #88888C;
	background-color: #F5FBF8;
}

#contact input[type="text"]:hover, #contact input[type="email"]:hover,
	#contact input[type="tel"]:hover, #contact input[type="url"]:hover,
	#contact select#profissao:hover {
	-webkit-transition: border-color 0.3s ease-in-out;
	-moz-transition: border-color 0.1s ease-in-out;
	transition: border-color 0.1s ease-in-out;
	border: 2px solid #c1c1c1;
}

#contact button[type="submit"] {
	cursor: pointer;
	width: 100%;
	border: none;
	border-radius: 5px;
	background: #017366;
	color: #FFF;
	margin: 0 0 5px;
	padding: 15px;
	font-size: 15px;
	font-weight: 600;
}

#contact button[type="submit"]:hover {
	background: #03A693;
	-webkit-transition: background 0.3s ease-in-out;
	-moz-transition: background 0.3s ease-in-out;
	transition: background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active {
	box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

#contact button[type="reset"] {
	cursor: pointer;
	width: 100%;
	border: none;
	border-radius: 5px;
	background: #017366;
	color: #FFF;
	margin: 0 0 5px;
	padding: 15px;
	font-size: 15px;
	font-weight: 600;
}

#contact button[type="reset"]:hover {
	background: #03A693;
	-webkit-transition: background 0.3s ease-in-out;
	-moz-transition: background 0.3s ease-in-out;
	transition: background-color 0.3s ease-in-out;
}

#contact button[type="reset"]:active {
	box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

.copyright {
	text-align: center;
}

#contact input:focus, #contact textarea:focus {
	outline: 0;
	border: 1px solid #aaa;
}

::-webkit-input-placeholder {
	color: #888;
}

:-moz-placeholder {
	color: #888;
}

::-moz-placeholder {
	color: #888;
}

:-ms-input-placeholder {
	color: #888;
}
</style>
</head>
<body>
	<div class="container">
		<form id="contact" action="ControladorProductos" method="get">
			<input type="hidden" name="instruccion" value="insertarBBDD">
			<h3>¿Quieres Insertar un Producto?</h3>
			<h4>Rellene todos los campos:</h4>
			<fieldset>
				<input placeholder="Código Artículo" type="text" name="CArt"
					required autofocus>
			</fieldset>
			<fieldset>
				<input placeholder="Sección" type="text" name="seccion" required>
			</fieldset>
			<fieldset>
				<input placeholder="Nombre Artículo" type="text" name="NArt"
					required>
			</fieldset>
			<fieldset>
				<input placeholder="Precio" type="text" name="precio" required>
			</fieldset>
			<fieldset>
				<input placeholder="Importado" type="text" name="importado" required>
			</fieldset>
			<fieldset>
				<input placeholder="Pais de Origen" type="text" name="POri" required>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Insertando">Insertar</button>
			</fieldset>
			<fieldset>
				<button name="reset" type="reset" id="borrar">Restablecer</button>
			</fieldset>
		</form>
	</div>
</body>
</html>