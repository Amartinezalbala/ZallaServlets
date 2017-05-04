package com.ipartek.ejemplos.alvaromartinez.DAL;

import com.ipartek.ejemplos.alvaromartinez.tipos.Usuario;

public class UsuariosDALFijo implements UsuariosDAL {

	private Usuario usuario;

	@Override
	public void alta(Usuario usuario) {
		this.usuario = usuario;

	}

	@Override
	public boolean validar(Usuario usuario) {
		return this.usuario.equals(usuario);
	}

}
