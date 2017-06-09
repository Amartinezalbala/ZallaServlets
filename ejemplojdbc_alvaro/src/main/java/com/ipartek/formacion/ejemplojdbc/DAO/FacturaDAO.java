package com.ipartek.formacion.ejemplojdbc.DAO;

import com.ipartek.formacion.ejemplojdbc.Tipos.Factura;

public interface FacturaDAO {
	public Factura[] findAll();

	public Factura findById(int id);

	public int insert(Factura factura);

	public void update(Factura factura);

	public void delete(Factura factura);

	public void delete(int id);
}
