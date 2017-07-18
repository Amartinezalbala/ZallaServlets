<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="titulo" value="LISTA DE PRODUCTOS" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
<h2>PRODUCTOS</h2>
<table>
	<thead>
  		<tr>
  			<th>CODIGO</th>
    		<th>NOMBRE</th>
    		<th>PRECIO</th>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${productos}" var="producto">
  			<tr>
    				<td>${producto.id}</td>
    				<td>${producto.nombre}</td>
					<td>${producto.precio}</td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>

<%@ include file="INCLUDES/PIE.jsp"%>