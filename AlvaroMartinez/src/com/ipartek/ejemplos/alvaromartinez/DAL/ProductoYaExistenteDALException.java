package com.ipartek.ejemplos.alvaromartinez.DAL;

public class ProductoYaExistenteDALException extends ProductosDALException {

	private static final long serialVersionUID = 1L;

	public ProductoYaExistenteDALException() {
		super();
	}

	public ProductoYaExistenteDALException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ProductoYaExistenteDALException(String message, Throwable cause) {
		super(message, cause);

	}

	public ProductoYaExistenteDALException(String message) {
		super(message);
	}

	public ProductoYaExistenteDALException(Throwable cause) {
		super(cause);
	}

}
