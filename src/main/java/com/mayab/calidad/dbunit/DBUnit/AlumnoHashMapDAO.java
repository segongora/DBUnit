/*
 * Sergio Gongora
 * 
 * 
 */

package com.mayab.calidad.dbunit.DBUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AlumnoHashMapDAO implements AlumnoDAO {

	public boolean insertarAlumno(Alumno a) {
		
		// TODO Auto-generated method stub
		
		try {
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CalidadSoftware"
					   +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","pass");
			   	  
			   	  // the mysql insert statement
			      String query = "INSERT INTO Alumno(ID, Name, lastName, Age, Average)"
			    		  + " values (?, ?, ?, ?, ?)";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setString (1, a.getID());
			      preparedStmt.setString (2, a.getNombre());
			      preparedStmt.setString (3, a.getApellido());
			      preparedStmt.setInt    (4, a.getEdad());
			      preparedStmt.setFloat  (5, a.getPromedio());

			      // execute the preparedstatement
			      preparedStmt.execute();
			      con.close();
			      
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		
		return false;
	}

	
	public boolean borrarAlumno(Alumno a) {
		
		// TODO Auto-generated method stub
		
		try {
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CalidadSoftware"
					   +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","pass");
			   	  
			   	  // the mysql insert statement
			      String query = "DELETE FROM Alumno WHERE ID = ?";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setString (1, a.getID());

			      // execute the preparedstatement
			      preparedStmt.execute();
			      con.close();
			      
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		return false;
	}

	
	public boolean actualizarPromedio(Alumno a, float nuevoPromedio) {
		
		// TODO Auto-generated method stub
		
		try {
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CalidadSoftware"
					   +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","pass");
			      
			   	  // the mysql insert statement
			      String query = "UPDATE Alumno SET average = ? WHERE id = ?";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setFloat  (1, nuevoPromedio);
			      preparedStmt.setString (2, a.getID());
			      

			      // execute the preparedstatement
			      preparedStmt.execute();
			      con.close();
			      
		   }catch(Exception ex) {
			   ex.printStackTrace();
		   }
		return false;
	}

	
	public boolean getAll(Alumno a) {
		
		// TODO Auto-generated method stub
		
		boolean queryPassed = false;
		
		try {
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CalidadSoftware"
					   +"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","pass");
			   	  
			   	  // the mysql insert statement
			      String query = "SELECT * FROM Alumno WHERE ID = ?";

			      // create the mysql insert preparedstatement
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setString (1, a.getID());
			      
			      // execute the preparedstatement
			      preparedStmt.execute();
			      con.close();
			      queryPassed = true;
			      
		   }catch(Exception ex) {
			   ex.printStackTrace();
			      queryPassed = false;
		   }
		
		if(queryPassed == true) { return true; }
		else {	return false; }
	}


}
