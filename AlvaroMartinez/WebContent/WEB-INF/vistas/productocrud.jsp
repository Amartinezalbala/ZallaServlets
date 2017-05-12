<%@ include file="includes/cabeceraProductos.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>PRODUCTOS</h2>
<table>
	<thead>
  		<tr>
  			<th>ACCION</th>
    		<th>CODIGO</th>
    		<th>NOMBRE</th>
    		<th>PRECIO</th>
  		</tr>
  	</thead>
  	<tbody>
  		<c:forEach items="${requestScope.productos}" var="producto">
  			<tr>
    			<td>
					<a href="?op=modificar&id=${producto.id}">MODIFICAR</a>
					<a href="?op=borrar&id=${producto.id}">BORRAR</a>
    			</td>
    				<td>${producto.id}</td>
    				<td>${producto.nombre}</td>
					<td>${producto.precio}</td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>




<a href="?op=agregar">AGREGAR</a>

<%@ include file="includes/pie.jsp"%>