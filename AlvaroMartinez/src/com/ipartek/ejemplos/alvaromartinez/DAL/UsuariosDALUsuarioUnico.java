package com.ipartek.ejemplos.alvaromartinez.DAL;

import com.ipartek.ejemplos.alvaromartinez.tipos.Usuario;

public class UsuariosDALUsuarioUnico implements UsuariosDAL {

	private Usuario usuario;

	@Override
	public void alta(Usuario usuario) {
		if (this.usuario.getNombre().equals(usuario.getNombre())) {
			throw new UsuarioYaExistenteDALException("IMPOSIBLE MODIFICAR: " + usuario + " , NO ENCONTRADO");
		}

		this.usuario = usuario;
	}

	@Override
	public boolean validar(Usuario usuario) {
		return this.usuario != null && this.usuario.equals(usuario);
	}

	@Override
	public void modificar(Usuario usuario) {
		if (!this.usuario.getNombre().equals(usuario.getNombre())) {
			throw new DALException("IMPOSIBLE MODIFICAR: " + usuario + " , NO ENCONTRADO");
		}
		this.usuario = usuario;

	}

	@Override
	public void borrar(Usuario usuario) {
		if (this.usuario.equals(usuario))
			this.usuario = null;
	}

	@Override
	public Usuario buscarPorId(String id) {
		return null;
	}

	@Override
	public Usuario[] buscarTodosLosUsuarios() {

		return null;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPass() {
		// TODO Auto-generated method stub
		return null;
	}

}
