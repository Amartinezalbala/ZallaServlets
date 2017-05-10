<%@ include file="includes/cabecera.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<h2>FORMULARIO DE USUARIOS</h2>
	
	<jsp:useBean id="usuario" scope="request"
		class="com.ipartek.ejemplos.alvaromartinez.tipos.Usuario" />

	<form action="UsuarioForm" method="post">
		<fieldset>
			<label for="nombre">NOMBRE</label> 
			
			<input id="nombre" name="nombre"
			  required="required" minlength="6" value="${usuario.nombre}" 
			  
			  <c:if test="${param.op == 'modificar' or param.op == 'borrar'}">
			  	readonly="readonly"
			  </c:if>   
		  	/>
		</fieldset>
		<fieldset>
			<label for="pass">CONTRASEÑA: </label> <input type="password" id="pass"
				name="pass" />
		</fieldset>
		<fieldset>
			<label for="pass2">CONTRASEÑA OTRA VEZ: </label> <input type="password" id="pass2"
				name="pass2" />
		</fieldset>
		<fieldset>
			<input type="submit" value="${fn:toUpperCase(param.op)}" />
			<p class="errores">${usuario.errores}</p>
			
			<input type="hidden" name="opform" value="${param.op}" />
		</fieldset>
	</form>
	
	<c:if test="${param.op == 'borrar'}">
		<script>
			document.forms[0].onsubmit = confirmarBorrado;
		</script>
	</c:if>
	
<%@ include file="includes/pie.jsp" %>