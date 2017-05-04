package com.ipartek.formacion.alvaromartinez.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuardarDatosServlet
 */
@WebServlet("/guardar")
public class GuardarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String informacion = request.getParameter("informacion"); // coger
																	// informacion
																	// de la url

		HttpSession bolsa = request.getSession(); // coger mi bolsa de cosas

		bolsa.setAttribute("idinfo", informacion); // poner id a la informacion

		ServletContext informacionGlobal = getServletContext(); // coger bolsa
																// comunitaria

		informacionGlobal.setAttribute("todos", "Común"); // poner id global

	}

}
