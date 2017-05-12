<%@ include file="includes/cabeceraProductos.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<h2>LISTA DE PRODUCTOS</h2>
	
	<jsp:useBean id="producto" scope="request"
		class="com.ipartek.ejemplos.alvaromartinez.tipos.Producto" />

	<form action="productoform" method="post">
		<fieldset>
			<label for="id">ID</label> 
			
			<input id="id" name="id"
			  required="required" minlength="3" value="${producto.id}" 
			  
			  <c:if test="${param.op == 'modificar' or param.op == 'borrar'}">
			  	readonly="readonly"
			  </c:if>   
		  	/>
		</fieldset>
		<fieldset>
			<label for="nombre">NOMBRE: </label> <input type="text" id="nombre"
				name="nombre" />
		</fieldset>
		<fieldset>
			<label for="precio">PRECIO: </label> <input type="number" id="precio"
				name="precio" />
		</fieldset>
		<fieldset>
			<input type="submit" value="${fn:toUpperCase(param.op)}" />
			
			
			<input type="hidden" name="opform" value="${param.op}" />
		</fieldset>
	</form>
	
	<c:if test="${param.op == 'borrar'}">
		<script>
			document.forms[0].onsubmit = confirmarBorrado;
		</script>
	</c:if>
	
<%@ include file="includes/pie.jsp" %>