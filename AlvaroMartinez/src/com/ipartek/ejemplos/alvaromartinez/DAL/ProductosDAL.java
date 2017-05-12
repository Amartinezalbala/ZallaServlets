package com.ipartek.ejemplos.alvaromartinez.DAL;

import com.ipartek.ejemplos.alvaromartinez.tipos.Producto;

public interface ProductosDAL {

	void añadir(Producto producto);

	public void modificar(Producto producto);

	public void borrar(Producto producto);

	public Producto buscarPorId(int id);

	public Producto[] buscarLosProductos();

	boolean validar(Producto producto);

}
