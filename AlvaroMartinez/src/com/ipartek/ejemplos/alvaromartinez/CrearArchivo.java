package com.ipartek.ejemplos.alvaromartinez;

import java.io.File;
import java.io.FileWriter;

public class CrearArchivo {

	public static void main(String[] args) {

		try {
			// Crear un objeto File se encarga de crear o abrir acceso a un
			// archivo que se especifica en su constructor
			File archivo = new File("archivo1.txt");

			// Crear objeto FileWriter que sera el que nos ayude a escribir
			// sobre archivo
			FileWriter escribir = new FileWriter(archivo, true);

			// Escribimos en el archivo con el metodo write
			escribir.write("HOLA");

			// Cerramos la conexion
			escribir.close();
		}

		// Si existe un problema al escribir cae aqui
		catch (Exception e) {
			System.out.println("Error al escribir");
		}
	}

}
