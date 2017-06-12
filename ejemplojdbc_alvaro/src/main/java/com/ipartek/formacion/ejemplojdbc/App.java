package com.ipartek.formacion.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplojdbc.DAO.DAOException;
import com.ipartek.formacion.ejemplojdbc.DAO.RolDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.RolDAOMySQL;
import com.ipartek.formacion.ejemplojdbc.Tipos.Rol;

public class App {
	public static void main(String[] args) {
		try {
			// Comprobaciones DAO
			// UsuarioDAO daoUsuarios = new UsuarioDAOMySQL();
			// daoUsuarios.abrir();
			RolDAO daoRoles = new RolDAOMySQL();
			daoRoles.abrir();

			// comprobacion de FindAll
			// for (Usuario u : daoUsuarios.findAll())
			// System.out.println(u);
			for (Rol r : daoRoles.findAll())
				System.out.println(r);

			// Comprobacion de FindById
			// int id = 3;
			// Usuario usuario = daoUsuarios.findById(id);
			// System.out.println("Usuario ID: " + id + " = " + usuario);
			int id = 1;
			Rol rol = daoRoles.findById(id);
			System.out.println("Rol ID: " + id + " = " + rol);

			// Comprobación insert
			// Usuario usuario0 = new Usuario(0, 3, "PruebaUsuarios", "PUPass",
			// "PruebaEclipse");
			// daoUsuarios.insert(usuario0);
			// System.out.println(daoUsuarios.findById(9));
			Rol rol0 = new Rol(0, "empleaducho", "PruebaEclipse");
			daoRoles.insert(rol0);
			System.out.println(daoRoles.findById(4));

			// comprobacion de update
			// Usuario usuario1 = new Usuario(5, 2, "Actualizado Updatez",
			// "actuaPass", "Updating");
			// daoUsuarios.update(usuario1);
			// System.out.println(daoUsuarios.findById(5));
			Rol rol1 = new Rol(4, "vedel", "PruebaEclipse");
			daoRoles.insert(rol1);
			System.out.println(daoRoles.findById(4));

			// comprobacion de delete
			// Usuario usuario2 = new Usuario(5, 2, "Actualizado Updatez",
			// "actuaPass", "Updating");
			// daoUsuarios.delete(usuario2);
			// System.out.println("Eliminado el registro: " + usuario2);
			Rol rol2 = new Rol(0, "vedel", "PruebaEclipse");
			daoRoles.delete(rol2);
			System.out.println("ELIMINADO EL REGISTRO: " + rol2);

			// comprobacion de deleteID
			// int id1 = 8;
			// daoUsuarios.findById(id1);
			// daoUsuarios.delete(id1);
			// System.out.println("Eliminado el registro número " + id1);
			int id1 = 3;
			daoRoles.findById(id1);
			daoRoles.delete(id1);
			System.out.println("Eliminado el registro número " + id1);

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
