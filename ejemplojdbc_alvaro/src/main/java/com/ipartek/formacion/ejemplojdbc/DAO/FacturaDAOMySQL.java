package com.ipartek.formacion.ejemplojdbc.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ipartek.formacion.ejemplojdbc.Tipos.Factura;
import com.ipartek.formacion.ejemplojdbc.Tipos.FacturaLinea;
import com.ipartek.formacion.ejemplojdbc.Tipos.Producto;

public class FacturaDAOMySQL extends IpartekDAOMySQL implements FacturaDAO {
	private final static String FIND_ALL = "SELECT * FROM facturas";
	private final static String FIND_BY_ID = "SELECT * FROM facturas WHERE id = ?";
	private final static String INSERT = "INSERT INTO facturas (numero_factura, id_usuarios, fecha)"
			+ " VALUES (?, ?, ?)";
	private final static String UPDATE = "UPDATE facturas " + "SET numero_factura = ?, id_usuarios = ?,fecha = ?"
			+ "WHERE id = ?";
	private final static String DELETE = "DELETE FROM facturas WHERE id = ?";
	private final static String FIND_ALL_LINEAS = "SELECT * FROM facturas_productos WHERE id_facturas = ?";
	private final static String FIND_LINEA_CANTIDAD = "SELECT * FROM facturas_productos WHERE id_facturas = ? AND id_productos = ?";
	private final static String UPDATE_LINEA_CANTIDAD = "UPDATE facturas_productos SET cantidad = ? WHERE id_facturas = ? AND id_productos = ?";
	private final static String DELETE_LINEA = "DELETE FROM facturas_productos WHERE id_facturas = ? AND id_productos = ?";
	private final static String INSERT_LINEA = "INSERT INTO facturas_productos (id_facturas, id_productos, cantidad) VALUES (?, ?, ?)";

	// private final static String FIND_NOMBRE_COMPLETO =
	// "SELECT nombre_completo"
	// +
	// " FROM usuarios u, facturas f, facturas_productos fp WHERE u.id = f.id_usuarios AND f.id = fp.id_facturas";

	private PreparedStatement psFindAll, psFindById, psInsert, psUpdate, psDelete, psFindAllLineas,
			psFindLineaCantidad, psUpdateLineaCantidad, psDeleteLinea, psInsertLinea;

	public Factura[] findAll() {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		ResultSet rs = null;

		try {
			psFindAll = con.prepareStatement(FIND_ALL);

			rs = psFindAll.executeQuery();

			Factura factura;

			while (rs.next()) {
				factura = new Factura();

				factura.setId(rs.getInt("id"));
				factura.setNúmero_factura(rs.getString("numero_factura"));
				factura.setId_usuarios(rs.getInt("id_usuarios"));
				factura.setFecha(rs.getDate("fecha"));

				facturas.add(factura);
			}

		} catch (SQLException e) {
			throw new DAOException("Error en findAll", e);
		} finally {
			cerrar(psFindAll, rs);
		}
		return facturas.toArray(new Factura[facturas.size()]);
	}

	public Factura findById(int id) {
		Factura factura = null;
		ResultSet rs = null;
		if (true) {
			try {
				psFindById = con.prepareStatement(FIND_BY_ID);

				psFindById.setInt(1, id);
				rs = psFindById.executeQuery();

				if (rs.next()) {
					factura = new Factura();

					factura.setId(rs.getInt("id"));
					factura.setNúmero_factura(rs.getString("numero_factura"));
					factura.setId_usuarios(rs.getInt("id_usuarios"));
					factura.setFecha(rs.getDate("fecha"));
				}

			} catch (SQLException e) {
				throw new DAOException("Error en FindById", e);
			} finally {
				cerrar(psFindById, rs);
			}

		}
		return factura;

	}

	public int insert(Factura factura) {
		ResultSet generatedKeys = null;

		try {
			psInsert = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);

			psInsert.setString(1, factura.getNúmero_factura());
			psInsert.setInt(2, factura.getId_usuarios());
			psInsert.setDate(3, new java.sql.Date(factura.getFecha().getTime()));

			int res = psInsert.executeUpdate();

			if (res != 1) {
				throw new DAOException("La inserción ha devuelto un valor " + res);
			}
			generatedKeys = psInsert.getGeneratedKeys();

			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			} else {
				throw new DAOException("No se ha recibido la clave generada");
			}

		} catch (SQLException e) {
			throw new DAOException("Error en el insert", e);
		} finally {
			cerrar(psInsert, generatedKeys);
		}

	}

	public void update(Factura factura) {

		try {
			psUpdate = con.prepareStatement(UPDATE);

			psUpdate.setString(1, factura.getNúmero_factura());
			psUpdate.setInt(2, factura.getId_usuarios());
			psUpdate.setDate(3, new java.sql.Date(factura.getFecha().getTime()));
			psUpdate.setInt(4, factura.getId());

			int res = psUpdate.executeUpdate();

			if (res != 1) {
				throw new DAOException("La actualización ha devuelto un valor " + res);
			}
		} catch (Exception e) {
			throw new DAOException("Error en el update", e);
		} finally {
			cerrar(psUpdate);
		}

	}

	public void delete(Factura factura) {
		delete(factura.getId());
	}

	public void delete(int id) {
		try {
			psDelete = con.prepareStatement(DELETE);

			psDelete.setInt(1, id);

			int res = psDelete.executeUpdate();

			if (res != 1) {
				throw new DAOException("La eliminación por ID ha devuelto un valor " + res);
			}
		} catch (Exception e) {
			throw new DAOException("Error en el deleteID", e);
		} finally {
			cerrar(psDelete);
		}

	}

	private void cerrar(PreparedStatement ps) {
		cerrar(ps, null);
	}

	private void cerrar(PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			throw new DAOException("Error en el cierre de ps o rs", e);
		}
	}

	public void insertLinea(int id_facturas, int id_productos, int cantidad) {
		try {
			// INSERTAR EN FACTURAS_PRODUCTOS LOS DATOS DE FACTURA_LINEA
			psInsertLinea = con.prepareStatement(INSERT_LINEA);

			psInsertLinea.setInt(1, id_facturas);
			psInsertLinea.setInt(2, id_productos);
			psInsertLinea.setInt(3, cantidad);

			int res = psInsertLinea.executeUpdate();

			if (res != 1) {
				throw new DAOException("La inserción de linea ha devuelto un valor " + res);
			}

		} catch (Exception e) {
			System.out.println("IMPOSIBLE INSERTLINEA");
		}

	}

	public void deleteLinea(int idFactura, int idProducto) {
		try {
			// BORRAR LINEA EN FACTURAS_PRODUCTOS QUE CORRESPONDA AL ID PRODUCTO
			// E ID FACTURA
			psDeleteLinea = con.prepareStatement(DELETE_LINEA);

			psDeleteLinea.setInt(1, idFactura);
			psDeleteLinea.setInt(2, idProducto);

			int res = psDeleteLinea.executeUpdate();

			if (res != 1) {
				System.out.println("BORRADO LÍNEA REALIZADA");
			} else {
				System.out.println("BORRADO LÍNEA NO REALIZADA");
			}
		} catch (Exception e) {
			System.out.println("IMPOSIBLE DELETELINEA");
		}
	}

	public void updateLinea(int idFactura, int idProducto, int cantidad) {
		try {
			// BUSCAR LA LINEA SEGUN EL ID DE PRODUCTO E ID DE FACTURA Y CAMBIAR
			// LA CANTIDAD
			psUpdateLineaCantidad = con.prepareStatement(UPDATE_LINEA_CANTIDAD);

			psUpdateLineaCantidad.setInt(1, cantidad);
			psUpdateLineaCantidad.setInt(2, idFactura);
			psUpdateLineaCantidad.setInt(3, idProducto);

			int res = psUpdateLineaCantidad.executeUpdate();
			if (res == 1) {
				System.out.println("ACTUALIZACIÓN CANTIDAD REALIZADA");
			} else {
				System.out.println("ACTUALIZACIÓN CANTIDAD NO REALIZADA");
			}
		} catch (Exception e) {
			System.out.println("IMPOSIBLE UPDATELINEA");
		}

	}

	public FacturaLinea findLineaByProductoId(int idFactura, int idProducto) {
		Factura factura = findById(idFactura);
		ResultSet rs = null;
		FacturaLinea facturaLinea = null;
		try {
			// BUSCAR EN SQL ID FACTURA e ID PRODUCTO EN FACTURAS_PRODUCTOS
			psFindLineaCantidad = con.prepareStatement(FIND_LINEA_CANTIDAD);
			psFindLineaCantidad.setInt(1, idFactura);
			psFindLineaCantidad.setInt(2, idProducto);
			rs = psFindLineaCantidad.executeQuery();
			ProductoDAO daoProducto = new ProductoDAOMySQL();
			daoProducto.reutilizarConexion(this);
			Producto producto = daoProducto.findById(idProducto);

			if (rs.next()) {
				facturaLinea = new FacturaLinea();
				facturaLinea.setFactura(factura);
				facturaLinea.setProducto(producto);
				int cantidad = rs.getInt("cantidad");
				facturaLinea.setCantidad(cantidad);
			}

		} catch (Exception e) {
			System.out.println("IMPOSIBLE FINDLINEABYPRODUCTOID");
		}
		return facturaLinea;

	}

	public FacturaLinea[] findAllLineas(int idFactura) {
		ArrayList<FacturaLinea> lineas = new ArrayList<FacturaLinea>();

		try {
			psFindAllLineas = con.prepareStatement(FIND_ALL_LINEAS);

			psFindAllLineas.setInt(1, idFactura);

			ResultSet rs = psFindAllLineas.executeQuery();

			ProductoDAO dao = new ProductoDAOMySQL();
			dao.reutilizarConexion(this);

			while (rs.next()) {
				lineas.add(new FacturaLinea(dao.findById(rs.getInt("id_productos")), rs.getInt("cantidad")));
			}
		} catch (Exception e) {
			System.out.println("EXCEPCIÓN DE FINDALLLINEAS");
			e.printStackTrace();
		}
		return lineas.toArray(new FacturaLinea[lineas.size()]);
	}

	public Factura findByIdFacturaCompleta(int id) {
		Factura factura = findById(id);

		UsuarioDAO daoUsuario = new UsuarioDAOMySQL();
		daoUsuario.reutilizarConexion(this);

		if (factura != null) {
			factura.setUsuario(daoUsuario.findById(factura.getId_usuarios()));
			for (FacturaLinea fl : findAllLineas(factura.getId())) {
				factura.addProductoYCantidad(fl.getProducto(), fl.getCantidad());
			}
		} else {
			System.out.println("NO EXISTE ID INDICADO");
		}
		return factura;
	}

	public void updateLinea(int idFactura, FacturaLinea linea) {
		updateLinea(idFactura, linea.getProducto().getId(), linea.getCantidad());

	}

	public void insertLinea(FacturaLinea linea) {
		insertLinea(linea.getFactura().getId(), linea.getProducto().getId(), linea.getCantidad());
	}

	public void deleteLinea(FacturaLinea linea) {
		deleteLinea(linea.getFactura().getId(), linea.getProducto().getId());
	}

}