package com.ipartek.ejemplos.alvaromartinez.DAL;

public class ProductosDALFactory {
	public static ProductosDAL getProductosDAL() {
		return new ProductosDALColeccion();
	}

}
