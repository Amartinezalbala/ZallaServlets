package com.ipartek.formacion.ejemplojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ipartek.formacion.ejemplojdbc.DAO.DAOException;
import com.ipartek.formacion.ejemplojdbc.DAO.UsuarioDAO;
import com.ipartek.formacion.ejemplojdbc.DAO.UsuarioDAOMySQL;

public class App {
	public static void main(String[] args) {
		try {
			UsuarioDAO dao = new UsuarioDAOMySQL();

			// comprobacion de FindAll
			// for (Usuario u : dao.findAll())
			// System.out.println(u);

			// Comprobacion de FindById
			// int id = 3;
			// Usuario usuario = dao.findById(id);
			// System.out.println("Usuario ID: " + id + " = " + usuario);

			// comprobacion de insert
			// Usuario usuario = new Usuario(0, 2, "Prueba_Java", "PJPass",
			// "Prueba_Eclipse");
			// dao.insert(usuario);
			// System.out.println(dao.findById(5));

			// comprobacion de update
			// Usuario usuario = new Usuario(5, 2, "Actualizado Updatez",
			// "actuaPass", "Updating");
			// dao.update(usuario);
			// System.out.println(dao.findById(5));

			// comprobacion de delete
			// Usuario usuario = new Usuario(5, 2, "Actualizado Updatez",
			// "actuaPass", "Updating");
			// dao.delete(usuario);
			// System.out.println("Eliminado el registro: " + usuario);

			// comprobacion de deleteID
			int id = 4;
			// Usuario usuario = dao.findById(id);
			dao.delete(id);
			System.out.println("Eliminado el registro número " + id);

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
