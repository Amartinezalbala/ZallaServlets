<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EJEMPLO MVC ÁLVARO</title>
<link rel="stylesheet" href="css/estilos.css" />
</head>
<body>
	<header>
	<h2>EJEMPLO MVC</h2>
	<p>EJEMPLOS DE USO DE MVC
	<h5><%= new java.util.Date() %></h5> </p>
	</header>
	<nav>
	<ul>
			<li><a href="alta">ALTA</a></li>
			
			<li><a href="login">LOGIN</a></li>
			
			<li><a href="login?opcion=logout">SALIR</a></li>
		</ul>
	</nav>