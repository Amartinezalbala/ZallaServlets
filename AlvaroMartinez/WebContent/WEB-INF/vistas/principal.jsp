<%@include file="includes/cabecera.jsp" %>
	<h1>Principal</h1>
	<jsp:useBean id="usuario" scope="session" 
	class ="com.ipartek.ejemplos.alvaromartinez.tipos.Usuario"/>
	<h1>Bienvenido ${usuario.nombre}  </h1>
	<a href="login?opcion=logout"> Logout</a>
	<h3><%= new java.util.Date() %></h3>
<%@include file="includes/pie.jsp" %>