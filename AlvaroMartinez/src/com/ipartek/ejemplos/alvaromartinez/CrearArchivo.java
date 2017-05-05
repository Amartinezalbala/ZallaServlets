package com.ipartek.ejemplos.alvaromartinez;

import java.io.File;
import java.io.FileWriter;

import com.ipartek.ejemplos.alvaromartinez.DAL.UsuariosDAL;

public class CrearArchivo {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		String nombre = "";
		String pass = "";
		UsuariosDAL usuarioAlta = null;

		try {
			// Crear un objeto File se encarga de crear o abrir acceso a un
			// archivo que se especifica en su constructor
			File archivo = new File("usuarios.txt");

			// Crear objeto FileWriter que sera el que nos ayude a escribir
			// sobre archivo
			FileWriter escribir = new FileWriter(archivo, true);
			//
			nombre = "Usuario: " + usuarioAlta.getNombre();
			pass = "Pass: " + usuarioAlta.getPass();
			// Escribimos en el archivo con el metodo write
			escribir.write(nombre);
			escribir.write(pass);

			// Cerramos la conexion
			escribir.close();
		}

		// Si existe un problema al escribir cae aqui
		catch (Exception e) {
			System.out.println("Error al escribir");
		}
	}
}
