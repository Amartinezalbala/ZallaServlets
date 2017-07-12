<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="titulo" value="USUARIOS" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
<h2>MANTENIMIENTO USUARIOS</h2>

<table border="1">
	<thead>
		<tr>
			<th>OPERACIONES</th>
			<th>USUARIO</th>
			<th>CONTRASEÑA</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items=>
			<tr>
				<td>
					<a href=>MODIFICAR</a>
					<a href=>BORRAR</a>
				</td>
				<td>${}</td>
				<td>${}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="?op=alta">ALTA</a>

<%@ include file="INCLUDES/PIE.jsp"%>
