<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="titulo" value="ALTA USUARIOS" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
<body>
	<hr><strong><u>INTRODUZCA NOMBRE DE USUARIO Y SU CORRESPONDIENTE CONTRASEÑA: </u></strong>
	
	<form >
		<fieldset>
			<label for="nombre">USUARIO : </label> <input 
			required = "required" minlength="6" />
		</fieldset>
		<fieldset>
			<label for="pass">CONTRASEÑA : </label> <input  />
		</fieldset>
		<fieldset>
			<label for="pass2">REPITE CONTRASEÑA : </label> <input />
		</fieldset>
		<fieldset>
			<input type="submit" value="LOGIN" />
		</fieldset>
	</form>
<%@ include file="INCLUDES/PIE.jsp" %>