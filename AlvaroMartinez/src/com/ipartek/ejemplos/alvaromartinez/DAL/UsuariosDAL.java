package com.ipartek.ejemplos.alvaromartinez.DAL;

import com.ipartek.ejemplos.alvaromartinez.tipos.Usuario;

public interface UsuariosDAL {
	void alta(Usuario usuario);

	public void modificar(Usuario usuario);

	public void borrar(Usuario usuario);

	public Usuario buscarPorId(String id);

	public Usuario[] buscarTodosLosUsuarios();

	boolean validar(Usuario usuario);

}
