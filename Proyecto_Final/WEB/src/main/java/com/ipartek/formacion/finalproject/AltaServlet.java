package com.ipartek.formacion.finalproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplojdbc.Tipos.Usuario;

@WebServlet("/alta")
public class AltaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/VISTAS/ALTA.jsp").forward(request, response);

		String user = request.getParameter("user");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String pass2 = request.getParameter("pass2");
		int id = 0;
		int rol = 0;
		Usuario usuario = new Usuario(id, rol, name, pass, user);

		boolean hayDatos = user != null && name != null && pass != null && pass2 != null;
		// boolean datosCorrectos = validarCampo(usuario) && validarCampo(pass)
		// && validarCampo(pass2);
		boolean passIguales = pass != null && pass.equals(pass2);

		if (hayDatos) {
			if (!passIguales) {
				System.out.println("LAS CONTRASEÑAS TIENEN QUE SER IGUALES.");
			} else {
				System.out.println("ALTA REALIZADA CORRECTA");
			}
		}

	}
	// private boolean validarCampo(String campo) {
	// return campo != null && campo.length() >= LoginServlet.MINIMO_CARACTERES;
	// }
}
