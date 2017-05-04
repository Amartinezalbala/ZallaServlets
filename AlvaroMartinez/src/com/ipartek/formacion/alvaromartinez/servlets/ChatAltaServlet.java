package com.ipartek.formacion.alvaromartinez.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/chatalta")
public class ChatAltaServlet<aliasFinal> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String aliasFinal = request.getParameter("alias"); // coger el alias
		session.setAttribute("alias", aliasFinal);

		PrintWriter out = response.getWriter();
		out.println("El alias privado es : " + aliasFinal);

	}

}
