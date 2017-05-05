<%@ include file="includes/cabecera.jsp" %>

	<h2>ALTA USUARIO</h2>
	
	<jsp:useBean id="usuario" scope="request"
	class="com.ipartek.ejemplos.alvaromartinez.tipos.Usuario" />
	
	<form action="alta" method="post">
		<fieldset>
			<label for="nombre">USUARIO :</label> <input id="nombre" name="nombre" 
			required = "required" minlength="6"  value="${usuario.nombre}"/>
		</fieldset>
		<fieldset>
			<label for="pass">CONTRASEÑA :</label> <input type="password" id="pass"
				name="pass" />
		</fieldset>
		<fieldset>
			<label for="pass2">REPITE CONTRASEÑA :</label> <input type="password" id="pass2"
				name="pass2" />
		</fieldset>
		<fieldset>
			<input type="submit" value="LOGIN" />
			<p class="errores">${usuario.errores }</p>
		</fieldset>
	</form>
<%@ include file="includes/pie.jsp" %>