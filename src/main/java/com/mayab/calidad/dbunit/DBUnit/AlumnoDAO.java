/*
 * Sergio Ganger
 * 
 * 
 */

package com.mayab.calidad.dbunit.DBUnit;

public interface AlumnoDAO {
	public boolean insertarAlumno(Alumno a);
	public boolean borrarAlumno(Alumno a);
	public boolean actualizarPromedio(Alumno a, float nuevoPromedio);
	public boolean getAll(Alumno a);
}
