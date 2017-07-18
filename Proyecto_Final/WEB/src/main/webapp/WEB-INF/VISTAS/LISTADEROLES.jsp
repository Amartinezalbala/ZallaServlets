<c:set var="titulo" value="LISTA DE ROLES" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
<h2>ROLES</h2>
<table>
	<thead>
  		<tr>
  			<th>CODIGO</th>
  			<th>ROL</th>
  			<th>DESCRIPCIÓN</th>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${roles}" var="rol">
  			<tr>
    				<td>${rol.id}</td>
    				<td>${rol.rol}</td>
					<td>${rol.descripcion}</td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>

<%@ include file="INCLUDES/PIE.jsp"%>