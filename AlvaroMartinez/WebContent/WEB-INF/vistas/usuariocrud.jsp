<%@ include file="includes/cabeceraProductos.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<c:forEach items="${requestScope.usuarios}" var="usuario">
			<tr>
				<td>
					<a href="?op=modificar&id=${usuario.nombre}">MODIFICAR</a>
					<a href="?op=borrar&id=${usuario.nombre}">BORRAR</a>
				</td>
				<td>${usuario.nombre}</td>
				<td>${usuario.pass}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="?op=alta">ALTA</a>

<%@ include file="includes/pie.jsp"%>
