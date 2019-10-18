package com.mayab.calidad.dbunit.DBUnit;

import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;

public class testBorrar extends DBTestCase {
	Alumno alumno;
	AlumnoHashMapDAO testAlumno;
	
	public testBorrar(String nombre){
		super(nombre);
		
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS,"com.mysql.cj.jdbc.Driver");
		
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL,"jdbc:mysql://localhost:3306/CalidadSoftware"
		+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "pass");
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		IDatabaseConnection con = getConnection();
		try {
			DatabaseOperation.CLEAN_INSERT.execute(con, getDataSet());
		}
		finally {
			con.close();
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		
		alumno = new Alumno("00317268","Sergio","Gongora",21,85.37f);
		testAlumno = new AlumnoHashMapDAO();
		
		IDatabaseConnection con = getConnection();
		int actualRows = con.getRowCount("Alumno");
		testAlumno.borrarAlumno(alumno);
		
		assertEquals(actualRows+1, con.getRowCount("Alumno"));
		con.close();
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		InputStream xmlFile =  getClass().getResourceAsStream("/insertTestCase.xml");
		return new FlatXmlDataSetBuilder().build(xmlFile);
	}

}
