package com.ipartek.formacion.ejemplojdbc.DAO;

import com.ipartek.formacion.ejemplojdbc.Tipos.Producto;

public interface ProductoDAO {
	public Producto[] findAll();

	public Producto findById(int id);

	public int insert(Producto producto);

	public void update(Producto producto);

	public void delete(Producto producto);

	public void delete(int id);
}
