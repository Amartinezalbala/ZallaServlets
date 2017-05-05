<%@include file="includes/cabecera.jsp" %>
	<h2>PRINCIPAL</h2>
	<jsp:useBean id="usuario" scope="session" 
	class ="com.ipartek.ejemplos.alvaromartinez.tipos.Usuario"/>
	<h1>Bienvenido ${usuario.nombre}  </h1>
	<a href="login?opcion=logout"> LOGOUT</a>
	<h3><%= new java.util.Date() %></h3>
<%@include file="includes/pie.jsp" %>