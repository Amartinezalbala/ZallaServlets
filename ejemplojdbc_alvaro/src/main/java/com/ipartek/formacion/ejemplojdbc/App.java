package com.ipartek.formacion.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.ipartek.formacion.ejemplojdbc.DAO.DAOException;
import com.ipartek.formacion.ejemplojdbc.DAO.FacturaDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.FacturaDAOMySQL;
import com.ipartek.formacion.ejemplojdbc.DAO.ProductoDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.RolDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.UsuarioDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.UsuarioDAOMySQL;
import com.ipartek.formacion.ejemplojdbc.Tipos.Factura;
import com.ipartek.formacion.ejemplojdbc.Tipos.FacturaLinea;
import com.ipartek.formacion.ejemplojdbc.Tipos.Producto;
import com.ipartek.formacion.ejemplojdbc.Tipos.Rol;
import com.ipartek.formacion.ejemplojdbc.Tipos.Usuario;

public class App {
	public static UsuarioDAO daoUsuarios = null;
	public static RolDAO daoRoles = null;
	public static ProductoDAO daoProductos = null;
	public static FacturaDAO daoFacturas = null;
	public static Factura visionado;

	public static FacturaDAO daoFactura = new FacturaDAOMySQL();
	public static UsuarioDAO daoUsuario = new UsuarioDAOMySQL();

	public static double iva21 = 0.21;

	public static void main(String[] args) {

		daoFactura.abrir();
		daoUsuario.reutilizarConexion(daoFactura);

		System.out
				.println("\n\n<=====================================================> Z@LL@ INFORMÁTIC@ <=====================================================>\n");
		IdFacturaFecha(2);

		System.out.println("CLIENTE : " + nombreUsuario(2, 1));

		productosFactura(2);
		System.out
				.println("\n"
						+ "<=====================================================> Z@LL@ INFORMÁTIC@ <=====================================================>");
		daoFactura.cerrar();
	}

	private static void IdFacturaFecha(int id_factura) {
		Factura factura = daoFactura.findById(id_factura);

		if (factura != null) {
			factura.setUsuario(daoUsuario.findById(factura.getId_usuarios()));
			int facturaId = factura.getId();
			Date fechaFactura = factura.getFecha();
			System.out.println("ID FACTURA: " + facturaId);
			System.out.println("FECHA FACTURA: " + fechaFactura);
		} else {
			System.out.println("NO EXISTE FACTURA CON ESE ID");
		}

	}

	private static String nombreUsuario(int id_factura, int id_usuario) {
		Usuario usuario = daoUsuario.findById(id_usuario);
		Factura factura = daoFactura.findById(id_factura);

		if (usuario != null || factura != null) {
			factura.setUsuario(daoUsuario.findById(factura.getId_usuarios()));
			String nombre_completo = usuario.getNombre_completo();
			return nombre_completo;
		} else {
			System.out.println("NO EXISTE FACTURA Y/O USUARIO CON ESOS ID");
		}
		String sinUsuario = "NO HAY USUARIO";
		return sinUsuario;
	}

	public static void productosFactura(int id_factura) {
		double iva21 = 0.21;
		double total_subtotal = 0.0;
		double total_iva = 0.0;
		double total_factura = 0.0;

		try {
			FacturaDAO daoFactura = new FacturaDAOMySQL();

			daoFactura.abrir();

			Factura factura = daoFactura.findByIdFacturaCompleta(id_factura);
			System.out
					.println("___________________________________________________________________________________________________________________________________");
			if (factura != null) {
				System.out
						.println("\n|   PRODUCTO   |   PRECIO   |   UNIDADES   |   SUBTOTAL   |   IVA 21%   |   TOTAL   |\n");

				for (FacturaLinea fl : daoFactura.findAllLineas(factura.getId())) {
					String nombre_producto = fl.getProducto().getNombre();
					double precio_producto = fl.getProducto().getPrecio();
					int unidades = fl.getCantidad();
					double subtotal = precio_producto * unidades;
					double iva = subtotal * iva21;
					double total_producto = subtotal + iva;
					System.out.println(nombre_producto + " | " + precio_producto + " €" + " |       " + unidades
							+ "       | " + subtotal + " €" + " | " + iva + " €" + " | " + total_producto + " € ");
					total_subtotal = total_subtotal + subtotal;
					total_iva = total_iva + iva;
					total_factura = total_factura + total_producto;
				}
				System.out.print("\n| TOTALES ======================>");
				System.out.println(" | SUBTOTAL : " + total_subtotal + " € | IVA 21% : " + total_iva
						+ " € | TOTAL FACTURA : " + total_factura + " € |");

			} else {
				System.out.println("NO EXISTE FACTURA CON ESE ID");
			}

		} catch (Exception e) {
			System.out.println("ERROR EN LA CREACIÓN DE FACTURA");
			e.printStackTrace();
		}

	}

	public static void mainAnterior(String[] args) {

		try {
			FacturaDAO facturadao = new FacturaDAOMySQL();
			facturadao.abrir();
			facturadao.deleteLinea(5, 7);
			System.out.println("Factura: 5 - Producto: 7 - Cantidad: 2 -> Linea borrada");
			facturadao.cerrar();
		}

		// visionado factura y productos con nombre completo

		// try {
		// FacturaDAO dao = new FacturaDAOMySQL();
		//
		// dao.abrir();
		//
		// for (Factura f : dao.findAll()) {
		// for (FacturaLinea fl : dao.findAllLineas(f.getId())) {
		// System.out.println("" + fl.getCantidad() + ", " + fl.getProducto());
		// }
		// }
		//
		// Factura factura = dao.findByIdFacturaCompleta(2);
		//
		// System.out.println(factura);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

		// listado de las tablas
		// daoUsuarios = new UsuarioDAOMySQL();
		// daoUsuarios.abrir();
		// listadoUsuarios();
		// daoUsuarios.cerrar();
		// daoRoles = new RolDAOMySQL();
		// daoRoles.abrir();
		// listadoRoles();
		// daoRoles.cerrar();
		// daoProductos = new ProductoDAOMySQL();
		// daoProductos.abrir();
		// listadoProductos();
		// daoProductos.cerrar();
		// daoFacturas = new FacturaDAOMySQL();
		// daoFacturas.abrir();
		// listadoFacturas();
		// daoFacturas.cerrar();

		// try {
		// Comprobaciones DAO
		// UsuarioDAO daoUsuarios = new UsuarioDAOMySQL();
		// daoUsuarios.abrir();
		// RolDAO daoRoles = new RolDAOMySQL();
		// daoRoles.abrir();
		// ProductoDAO daoProductos = new ProductoDAOMySQL();
		// daoProductos.abrir();
		// FacturaDAO daoFacturas = new FacturaDAOMySQL();
		// daoFacturas.abrir();

		// comprobacion de FindAll
		// for (Usuario u : daoUsuarios.findAll()){
		// System.out.println(u);}
		// for (Rol r : daoRoles.findAll()){
		// System.out.println(r);}
		// for (Producto p : daoProductos.findAll()){
		// System.out.println(p);}
		// for (Factura f : daoFacturas.findAll()) {
		// System.out.println(f);
		// }

		// Comprobacion de FindById
		// int id = 1;
		// Usuario usuario = daoUsuarios.findById(id);
		// System.out.println("Usuario ID: " + id + " = " + usuario);
		// int id = 1;
		// Rol rol = daoRoles.findById(id);
		// System.out.println("Rol ID: " + id + " = " + rol);
		// int id = 1;
		// Producto producto = daoProductos.findById(id);
		// System.out.println("Producto ID: " + id + " = " + producto);
		// int id = 1;
		// Factura factura = daoFacturas.findById(id);
		// System.out.println("Factura ID: " + id + " = " + factura);

		// Comprobación insert
		// Usuario usuario0 = new Usuario(0, 3, "PruebaUsuarios", "PUPass",
		// "PruebaEclipse");
		// daoUsuarios.insert(usuario0);
		// System.out.println(daoUsuarios.findById(9));
		// Rol rol0 = new Rol(0, "empleaducho2", "PruebaEclipse8");
		// daoRoles.insert(rol0);
		// System.out.println(daoRoles.findById(2));
		// Producto prod0 = new Producto(0, "Base Refigeradora Portatil",
		// 34.95);
		// daoProductos.insert(prod0);
		// System.out.println(daoProductos.findById(4));
		// @SuppressWarnings("deprecation")
		// Factura fact0 = new Factura(0, "PCBILBO001", 3, new Date(117, 5,
		// 20));
		// daoFacturas.insert(fact0);
		// System.out.println(daoFacturas.findById(4));

		// comprobacion de update
		// Usuario usuario1 = new Usuario(5, 2, "Actualizado Updatez",
		// "actuaPass", "Updating");
		// daoUsuarios.update(usuario1);
		// System.out.println(daoUsuarios.findById(5));
		// Rol rol1 = new Rol(22, "vedel", "PruebaEclipse9");
		// daoRoles.update(rol1);
		// System.out.println(daoRoles.findById(22));
		// Producto prod1 = new Producto(4, "Ratón optico", 15.99);
		// daoProductos.update(prod1);
		// System.out.println(daoProductos.findById(4));
		// @SuppressWarnings("deprecation")
		// Factura fact1 = new Factura(4, "NISU S.L.", 1, new Date(117, 5,
		// 20));
		// daoFacturas.update(fact1);
		// System.out.println(daoFacturas.findById(4));

		// comprobacion de delete
		// Usuario usuario2 = new Usuario(5, 2, "Actualizado Updatez",
		// "actuaPass", "Updating");
		// daoUsuarios.delete(usuario2);
		// System.out.println("Eliminado el registro: " + usuario2);
		// Rol rol2 = new Rol(22, "vedel2", "PruebaEclipse9");
		// daoRoles.delete(rol2);
		// System.out.println("ELIMINADO EL REGISTRO: " + rol2);
		// Producto prod2 = new Producto(4, "Ratón optico", 15);
		// daoProductos.delete(prod2);
		// System.out.println(daoProductos.findById(4));
		// @SuppressWarnings("deprecation")
		// Factura fact2 = new Factura(4, "NISU S.L.", 1, new Date(117, 5,
		// 20));
		// daoFacturas.delete(fact2);
		// System.out.println(daoFacturas.findById(4));

		// comprobacion de deleteID
		// int id1 = 8;
		// daoUsuarios.findById(id1);
		// daoUsuarios.delete(id1);
		// System.out.println("Eliminado el registro número " + id1);
		// int id1 = 23;
		// daoRoles.findById(id1);
		// daoRoles.delete(id1);
		// System.out.println("Eliminado el rol número " + id1);
		// int id1 = 2;
		// daoProductos.findById(id1);
		// System.out.println(daoProductos.findById(id1));
		// daoProductos.delete(id1);
		// System.out.println("Eliminado el producto número " + id1);
		// int id1 = 2;
		// daoFacturas.findById(id1);
		// daoFacturas.delete(id1);
		// System.out.println("Eliminado la factura número " + id1);

		// }

		catch (DAOException e) {
			e.printStackTrace();
			if (e.getCause() != null) {
				e.getCause().printStackTrace();
			}
		}
	}

	@SuppressWarnings("unused")
	private static void listadoUsuarios() {

		try {
			System.out
					.println("==========================================\nLISTADO USUARIOS\n==========================================");

			for (Usuario u : daoUsuarios.findAll()) {
				System.out.println(u);
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("LISTADO DE USUARIOS IMPOSIBLE DE MOSTAR");
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private static void listadoRoles() {

		try {
			System.out
					.println("==========================================\nLISTADO ROLES\n==========================================");

			for (Rol r : daoRoles.findAll()) {
				System.out.println(r);
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("LISTADO DE ROLES IMPOSIBLE DE MOSTAR");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void listadoProductos() {

		try {
			System.out
					.println("==========================================\nLISTADO PRODUCTOS\n==========================================");

			for (Producto p : daoProductos.findAll()) {
				System.out.println(p);
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("LISTADO DE PRODUCTOS IMPOSIBLE DE MOSTAR");
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void listadoFacturas() {

		try {
			System.out
					.println("==========================================\nLISTADO FACTURAS\n==========================================");

			for (Factura f : daoFacturas.findAll()) {
				System.out.println(f);
			}
			System.out.println();
		} catch (Exception e) {
			System.out.println("LISTADO DE FACTURAS IMPOSIBLE DE MOSTAR");
		}

	}

	public static void mainBasico(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		String url = "jdbc:mysql://localhost/ipartek?user=root&password=";

		Connection con = DriverManager.getConnection(url);

		// Statement st = con.createStatement();

		String sql = "SELECT * FROM usuarios WHERE id=?";

		PreparedStatement pst = con.prepareStatement(sql);

		int id = 4;

		pst.setInt(1, id);

		// String sql = "SELECT * FROM usuarios WHERE id=" + id;

		ResultSet rs = pst.executeQuery(); // st.executeQuery(sql);

		while (rs.next())
			System.out.println(rs.getString("username") + ", " + rs.getString("nombre_completo"));

		rs.close();
		// st.close();
		pst.close();

		String sqlInsert = "INSERT INTO usuarios (username, password, nombre_completo) " + "VALUES (?, ?, ?)";

		PreparedStatement pstInsert = con.prepareStatement(sqlInsert);

		//
		String username = "jdbcnuevo", password = "jdbcnuevopass", nombre_completo = "JDBC";

		pstInsert.setString(1, username);
		pstInsert.setString(2, password);
		pstInsert.setString(3, nombre_completo);

		int res = pstInsert.executeUpdate();

		System.out.println("Se ha modificado " + res + " registros");
		//

		String sqlUpdate = "UPDATE usuarios SET username=?, password=?, nombre_completo=? " + "WHERE id=?";

		PreparedStatement pstUpdate = con.prepareStatement(sqlUpdate);

		//
		username = "jdbcmodificado";
		password = "jdbcnuevopass";
		nombre_completo = "JDBC";

		pstUpdate.setString(1, username);
		pstUpdate.setString(2, password);
		pstUpdate.setString(3, nombre_completo);
		pstUpdate.setInt(4, id);

		res = pstUpdate.executeUpdate();

		System.out.println("Se ha modificado " + res + " registros");

		con.close();

		// https://dev.mysql.com/doc/connector-j/5.1/en/connector-j-usagenotes-statements.html
	}
}
