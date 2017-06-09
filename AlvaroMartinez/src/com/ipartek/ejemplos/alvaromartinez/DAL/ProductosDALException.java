package com.ipartek.ejemplos.alvaromartinez.DAL;

public class ProductosDALException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductosDALException() {
		super();

	}

	public ProductosDALException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public ProductosDALException(String message, Throwable cause) {
		super(message, cause);

	}

	public ProductosDALException(String message) {
		super(message);

	}

	public ProductosDALException(Throwable cause) {
		super(cause);

	}

}
