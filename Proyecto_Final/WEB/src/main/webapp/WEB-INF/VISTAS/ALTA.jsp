<%@ include file="includes/CABECERA_ALTA.jsp" %>
<body>
	<hr><strong><u>INTRODUZCA NOMBRE DE USUARIO Y SU CORRESPONDIENTE CONTRASE�A</u></strong>
	
	<form >
		<fieldset>
			<label for="nombre">USUARIO : </label> <input 
			required = "required" minlength="6" />
		</fieldset>
		<fieldset>
			<label for="pass">CONTRASE�A : </label> <input  />
		</fieldset>
		<fieldset>
			<label for="pass2">REPITE CONTRASE�A : </label> <input />
		</fieldset>
		<fieldset>
			<input type="submit" value="LOGIN" />
		</fieldset>
	</form>
<%@ include file="includes/PIE.jsp" %>