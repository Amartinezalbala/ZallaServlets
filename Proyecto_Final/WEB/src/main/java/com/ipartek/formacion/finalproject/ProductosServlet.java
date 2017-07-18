package com.ipartek.formacion.finalproject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplojdbc.DAO.ProductoDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.ProductoDAOMySQL;
import com.ipartek.formacion.ejemplojdbc.Tipos.Producto;

@WebServlet("/productos_lista")
public class ProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductoDAO productosDao = new ProductoDAOMySQL();
		productosDao.abrir();
		Producto[] productos = productosDao.findAll();
		productosDao.cerrar();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("/WEB-INF/VISTAS/LISTADEPRODUCTOS.jsp").forward(request, response);
	}

}
