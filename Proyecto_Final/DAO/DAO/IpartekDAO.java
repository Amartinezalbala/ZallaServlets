package com.ipartek.formacion.ejemplojdbc.DAO;

public interface IpartekDAO {
	public void abrir();

	public void cerrar();

	public void reutilizarConexion(IpartekDAO daoIpartek);

	public void iniciarTransaccion();

	public void confirmarTransaccion();

	public void deshacerTransaccion();
}
