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
import com.ipartek.formacion.ejemplojdbc.Tipos.Factura;

public class App {
	public static void main(String[] args) {
		try {
			// Comprobaciones DAO
			// UsuarioDAO daoUsuarios = new UsuarioDAOMySQL();
			// daoUsuarios.abrir();
			// RolDAO daoRoles = new RolDAOMySQL();
			// daoRoles.abrir();
			// ProductoDAO daoProductos = new ProductoDAOMySQL();
			// daoProductos.abrir();
			FacturaDAO daoFacturas = new FacturaDAOMySQL();
			daoFacturas.abrir();

			// comprobacion de FindAll
			// for (Usuario u : daoUsuarios.findAll()){
			// System.out.println(u);}
			// for (Rol r : daoRoles.findAll()){
			// System.out.println(r);}
			// for (Producto p : daoProductos.findAll()){
			// System.out.println(p);}
			for (Factura f : daoFacturas.findAll()) {
				System.out.println(f);
			}

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
			int id = 1;
			Factura factura = daoFacturas.findById(id);
			System.out.println("Factura ID: " + id + " = " + factura);

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
			@SuppressWarnings("deprecation")
			Factura fact2 = new Factura(4, "NISU S.L.", 1, new Date(117, 5, 20));
			daoFacturas.delete(fact2);
			System.out.println(daoFacturas.findById(4));

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

		} catch (DAOException e) {
			e.printStackTrace();
			if (e.getCause() != null) {
				e.getCause().printStackTrace();
			}
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
