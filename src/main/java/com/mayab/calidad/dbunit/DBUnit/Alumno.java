/*
 * Sergio Gongora
 * 
 * 
 */

package com.mayab.calidad.dbunit.DBUnit;

public class Alumno {

	private String ID;
	private String nombre;
	private String apellido;
	private int edad;
	private float promedio;
	
	Alumno() {
		this.ID="";
		this.nombre="";
		this.apellido="";
		this.edad=0;
		this.promedio=0.0f;
	}
	
	Alumno(String ID, String nombre, String apellido, int edad, float promedio) {
		this.setID(ID);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEdad(edad);
		this.setPromedio(promedio);
	}
	
	//Sets
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}
	
	//Gets
	public String getID() {
		return this.ID;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public int getEdad() {
		return this.edad;
	}
	public float getPromedio() {
		return this.promedio;
	}
	
}
