package com.ipartek.formacion.finalproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplojdbc.DAO.RolDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.RolDAOMySQL;
import com.ipartek.formacion.ejemplojdbc.Tipos.Rol;

@WebServlet("/roles_lista")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RolDAO rolesDao = new RolDAOMySQL();
		rolesDao.abrir();
		Rol[] roles = rolesDao.findAll();
		rolesDao.cerrar();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/WEB-INF/VISTAS/LISTADEROLES.jsp").forward(request, response);
	}

}
