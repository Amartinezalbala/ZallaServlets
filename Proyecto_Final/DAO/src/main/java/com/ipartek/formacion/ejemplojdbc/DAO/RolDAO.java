package com.ipartek.formacion.ejemplojdbc.DAO;

import com.ipartek.formacion.ejemplojdbc.Tipos.Rol;

public interface RolDAO extends IpartekDAO {
	public Rol[] findAll();

	public Rol findById(int id);

	public int insert(Rol rol);

	public void update(Rol rol);

	public void delete(Rol rol);

	public void delete(int id);

}
