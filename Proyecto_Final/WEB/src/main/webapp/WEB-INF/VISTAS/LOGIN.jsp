<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="titulo" value="LOGIN USUARIOS" />
<%@ include file="INCLUDES/CABECERA.jsp" %>
<body>
	<hr><strong><u>INTRODUZCA NOMBRE DE USUARIO Y SU CORRESPONDIENTE CONTRASEÑA</u></strong>
		<form >
		<fieldset>
			<label ><strong>USUARIO : </strong></label> <input	/>
		</fieldset>
		<fieldset>
			<label><strong>CONTRASEÑA : </strong></label> <input >
		</fieldset>
		<fieldset>
			<input type="submit" value="LOGIN" />
		</fieldset>
	</form>
<%@ include file="INCLUDES/PIE.jsp" %>