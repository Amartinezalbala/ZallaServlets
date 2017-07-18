<c:set var="titulo" value="LISTA DE FACTURAS" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
<h2>ROLES</h2>
<table>
	<thead>
  		<tr>
  			<th>CODIGO</th>
  			<th>NÚMERO DE FACTURA</th>
  			<th>USUARIO</th>
			<th>FECHA</th>
		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${facturas}" var="factura">
  			<tr>
    				<td>${factura.id}</td>
    				<td>${factura.numero_factura}</td>
					<td>${factura.id_usuarios}</td>
					<td>${factura.fecha}</td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>

<%@ include file="INCLUDES/PIE.jsp"%>