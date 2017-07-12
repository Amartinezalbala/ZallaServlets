<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="titulo" value="PRINCIPAL" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
	<h1> BIENVENIDO   </h1>
	<a href=> LOG-OUT</a>
	<h3><%= new java.util.Date() %></h3>
<%@include file="INCLUDES/PIE.jsp" %>