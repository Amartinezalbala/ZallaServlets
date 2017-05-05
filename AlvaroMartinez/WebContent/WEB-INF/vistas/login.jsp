<%@ include file="includes/cabecera.jsp" %>

	<jsp:useBean id="usuario" scope="request"
	class="com.ipartek.ejemplos.alvaromartinez.tipos.Usuario" />
	
	<form action="login" method="get">
		<fieldset>
			<label for="nombre">Nombre</label> <input id="nombre" name="nombre" 
			required = "required" minlength="4"  value="${usuario.nombre}"/>
		</fieldset>
		<fieldset>
			<label for="pass">Contraseña</label> <input type="password" id="pass"
				name="pass" />
		</fieldset>
		<fieldset>
			<input type="submit" value="LOGIN" />
			<p class="errores">${usuario.errores }</p>
		</fieldset>
	</form>
<%@ include file="includes/pie.jsp" %>