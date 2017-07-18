package com.ipartek.formacion.finalproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplojdbc.DAO.FacturaDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.FacturaDAOMySQL;
import com.ipartek.formacion.ejemplojdbc.Tipos.Factura;

@WebServlet("/facturas_lista")
public class FacturasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacturaDAO facturasDao = new FacturaDAOMySQL();
		facturasDao.abrir();
		Factura[] facturas = facturasDao.findAll();
		facturasDao.cerrar();
		request.setAttribute("facturas", facturas);
		request.getRequestDispatcher("/WEB-INF/VISTAS/LISTADEFACTURAS.jsp").forward(request, response);
	}

}
