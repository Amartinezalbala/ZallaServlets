package com.ipartek.formacion.ejemplojdbc.DAO;

import com.ipartek.formacion.ejemplojdbc.Tipos.Factura;
import com.ipartek.formacion.ejemplojdbc.Tipos.FacturaLinea;

public interface FacturaDAO extends IpartekDAO {
	public Factura[] findAll();

	public Factura findById(int id);

	public int insert(Factura factura);

	public void update(Factura factura);

	public void delete(Factura factura);

	public void delete(int id);

	public FacturaLinea[] findAllLineas(int idFactura);

	public Factura findByIdFacturaCompleta(int id);

	public void insertLinea(FacturaLinea linea);
}
