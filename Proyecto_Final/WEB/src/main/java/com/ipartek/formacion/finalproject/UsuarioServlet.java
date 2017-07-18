package com.ipartek.formacion.finalproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplojdbc.DAO.UsuarioDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.UsuarioDAOMySQL;
import com.ipartek.formacion.ejemplojdbc.Tipos.Usuario;

@WebServlet("/usuarios_lista")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO usuariosDao = new UsuarioDAOMySQL();
		usuariosDao.abrir();
		Usuario[] usuarios = usuariosDao.findAll();
		usuariosDao.cerrar();
		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("/WEB-INF/VISTAS/LISTADEUSUARIOS.jsp").forward(request, response);
	}

}
