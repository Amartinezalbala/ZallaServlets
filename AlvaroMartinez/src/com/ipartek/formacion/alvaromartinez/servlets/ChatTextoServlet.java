package com.ipartek.formacion.alvaromartinez.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/chattexto")
public class ChatTextoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		ServletContext informacionGlobal = getServletContext(); // coger bolsa
																// comunitaria

		HttpSession session = request.getSession();

		String mensaje = request.getParameter("texto"); // coger el mensaje

		String mensajesAnteriores = (String) informacionGlobal.getAttribute("chat");
		String alias = (String) session.getAttribute("alias");

		String chatCompleto = (mensajesAnteriores == null ? "" : mensajesAnteriores) + alias + ": " + mensaje
				+ " <br />";

		informacionGlobal.setAttribute("chat", chatCompleto);

		PrintWriter out = response.getWriter();
		// out.println("El mensaje enviado es : " + mensaje);
		out.println(chatCompleto);

	}
}
