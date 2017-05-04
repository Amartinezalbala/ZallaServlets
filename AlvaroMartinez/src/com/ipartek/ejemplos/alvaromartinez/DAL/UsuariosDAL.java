package com.ipartek.ejemplos.alvaromartinez.DAL;

import com.ipartek.ejemplos.alvaromartinez.tipos.Usuario;

public interface UsuariosDAL {
	void alta(Usuario usuario);

	boolean validar(Usuario usuario);

}
