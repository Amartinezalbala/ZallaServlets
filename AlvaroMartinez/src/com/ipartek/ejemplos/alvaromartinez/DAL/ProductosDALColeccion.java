package com.ipartek.ejemplos.alvaromartinez.DAL;

import java.util.Map;
import java.util.TreeMap;

import com.ipartek.ejemplos.alvaromartinez.tipos.Producto;

public class ProductosDALColeccion implements ProductosDAL {

	private Map<Integer, Producto> productos = new TreeMap<Integer, Producto>();

	@Override
	public void añadir(Producto producto) {
		if (productos.containsKey(producto.getId())) {
			throw new ProductoYaExistenteDALException("PRODUCTO EXISTENTE: " + producto.getNombre());
		}
		productos.put(producto.getId(), producto);
	}

	@Override
	public boolean validar(Producto producto) {
		return productos.containsValue(producto);
	}

	@Override
	public void modificar(Producto producto) {
		if (!productos.containsKey(producto.getNombre())) {
			throw new ProductoYaExistenteDALException("IMPOSIBLE MODIFICAR: " + producto + " , NO EXISTENTE");
		}
		productos.put(producto.getId(), producto);
	}

	@Override
	public void borrar(Producto producto) {
		productos.remove(producto).getId();

	}

	@Override
	public Producto buscarPorId(int id) {
		return productos.get(id);
	}

	@Override
	public Producto[] buscarLosProductos() {
		return productos.values().toArray(new Producto[productos.size()]);
	}

}
