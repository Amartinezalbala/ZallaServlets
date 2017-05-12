package com.ipartek.formacion.alvaromartinez.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.ejemplos.alvaromartinez.DAL.ProductoYaExistenteDALException;
import com.ipartek.ejemplos.alvaromartinez.DAL.ProductosDAL;
import com.ipartek.ejemplos.alvaromartinez.tipos.Producto;

@WebServlet("/productoform")
public class ProductoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String op = request.getParameter("opform");

		String sId = request.getParameter("id");
		String sNombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");

		int idForm = 0;
		if (sId != null) {
			idForm = Integer.parseInt(sId);
		}
		String nombreForm = null;
		if (sNombre != null) {
			nombreForm = sNombre;
		}
		double precioForm = 0;
		if (sPrecio != null) {
			precioForm = Double.parseDouble(sPrecio);
		}

		RequestDispatcher rutaListado = request.getRequestDispatcher(ProductoCRUDServlet.RUTA_SERVLET_LISTADO);
		RequestDispatcher rutaFormulario = request.getRequestDispatcher(ProductoCRUDServlet.RUTA_FORMULARIO);

		if (op == null) {
			rutaListado.forward(request, response);
			return;
		}

		Producto producto = new Producto(idForm, nombreForm, precioForm);

		ServletContext application = request.getServletContext();
		ProductosDAL dal = (ProductosDAL) application.getAttribute("dal");

		switch (op) {
		case "agregar":
			try {
				dal.agregar(producto);
			} catch (ProductoYaExistenteDALException pye) {
				producto.setErrores(pye.getMessage());
				request.setAttribute("producto", producto);
				rutaFormulario.forward(request, response);
				return;
			}
			rutaListado.forward(request, response);
			break;
		case "modificar":
			dal.modificar(producto);
			rutaListado.forward(request, response);
			break;
		case "borrar":
			dal.borrar(producto);
			rutaListado.forward(request, response);
			break;
		}

	}

}
