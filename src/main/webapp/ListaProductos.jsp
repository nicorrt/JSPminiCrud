<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
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


.filas {
	border-radius: 10px;
	border: medium none !important;
}

fieldset {
	border: medium none !important;
	border-radius: 10px;
	margin: 10px 10px 10px;
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
	border: 1px solid #c1c1c1;
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
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">Código Artículo</th>
							<th scope="col">Sección</th>
							<th scope="col">Nombre Artículor</th>
							<th scope="col">Precio</th>
							<th scope="col">Importado</th>
							<th scope="col">País de Origen</th>
							<th scope="col">Acciones</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="tempProducto" items="${LISTAPRODUCTOS}">
							<!-- Link para Cada producto con su campo clave -->
							<c:url var="linkTemp" value="ControladorProductos">
								<c:param name="instruccion" value="cargar"></c:param>
								<c:param name="CArticulo" value="${tempProducto.codigoArticulo}"></c:param>
							</c:url>
							<c:url var="linkTempEliminar" value="ControladorProductos">
								<c:param name="instruccion" value="eliminar"></c:param>
								<c:param name="CArticulo" value="${tempProducto.codigoArticulo}"></c:param>
							</c:url>
							<input type="hidden" name="instruccion" value="insertarBBDD">
							<tr>
								<th scope="row" class="cabecera">${tempProducto.codigoArticulo}</th>
								<td class="filas">${tempProducto.seccion}</td>
								<td class="filas">${tempProducto.nombreArticulo}</td>
								<td class="filas">${tempProducto.precio}</td>
								<td class="filas">${tempProducto.importado}</td>
								<td class="filas">${tempProducto.pOrigen}</td>
								<td>
									<form>
										<a href="${linkTemp}"> <input type="button" value="Ver">
										</a>
									</form>
									<form>
										<a href="${linkTemp}"> <input type="button"
											value="Actualizar">
										</a>
									</form>
									<form>
										<a href="${linkTempEliminar}"> <input type="button"
											value="Borrar">
										</a>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Insertando"
					onclick="window.location.href='inserta_producto.jsp'">Insertar
					Registro</button>
			</div>
		</div>
	</div>
</body>
</html>