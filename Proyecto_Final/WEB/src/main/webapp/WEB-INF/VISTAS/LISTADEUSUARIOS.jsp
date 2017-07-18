<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="titulo" value="LISTA DE USUARIOS" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
<h2>USUARIOS</h2>
<table>
	<thead>
  		<tr>
  			<th>CODIGO</th>
  			<th>ROL</th>
  			<th>USUARIO</th>
  			<th>CONTRASEÑA</th>
    		<th>NOMBRE COMPLETO</th>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${usuarios}" var="usuario">
  			<tr>
    				<td>${usuario.id}</td>
    				<td>${usuario.id_roles}</td>
					<td>${usuario.username}</td>
					<td>${usuario.password}</td>
					<td>${usuario.nombre_completo}</td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>

<%@ include file="INCLUDES/PIE.jsp"%>