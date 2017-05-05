package com.ipartek.ejemplos.alvaromartinez;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.alvaromartinez.DAL.UsuariosDAL;
import com.ipartek.ejemplos.alvaromartinez.DAL.UsuariosDALUsuarioUnico;
import com.ipartek.ejemplos.alvaromartinez.tipos.Usuario;

@WebServlet(name = "Saludo", urlPatterns = { "/hola" })
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/plain"); // formato bloc de notas
		PrintWriter out = response.getWriter(); // canal de escritura con el
												// navegador
		out.println("Ejemplo de Hola Mundo en Servlet por Eclipse por Álvaro");
		// texto ke te sale

		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");

		Usuario usuario = new Usuario(nombre, pass);

		UsuariosDAL usuarioDAL = new UsuariosDALUsuarioUnico();
		usuarioDAL.alta(new Usuario("Álvaro", "27101983A"));
		UsuariosDAL usuarioDAL1 = new UsuariosDALUsuarioUnico();
		usuarioDAL1.alta(new Usuario("prueba", "123456"));

		if (usuarioDAL.validar(usuario))
			out.println("BIENVENIDO " + usuario.getNombre().toUpperCase());
		else if (usuarioDAL1.validar(usuario))
			out.println("BIENVENIDO " + usuario.getNombre().toUpperCase());
		else if (nombre == null || nombre.trim().length() == 0) {
			out.println("HOLA DESCONOCIDO");
		} else {
			out.println("USUARIO NO VALIDO");
		}

		// if (nombre == null || nombre.trim().length() == 0) {
		// out.println("HOLA DESCONOCIDO");
		// } else if ("Álvaro Martínez Albalá".equals(nombre) &&
		// "27101983A".equals(pass)) {
		// out.println("BIENVENIDO " + nombre.toUpperCase());
		// } else {
		// out.println("NOMBRE Y CONTRASEÑA INCORRECTAS");
		// }

		out.println("¿QUÉ TAL " + usuario.getNombre().toUpperCase() + "?"); // fecha
																			// actual
	}

}
