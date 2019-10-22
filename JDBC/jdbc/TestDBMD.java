package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class TestDBMD {

	public static void main(String[] args) throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded......");

		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","123456789");
		System.out.println("Connection is created");


		DatabaseMetaData db = con.getMetaData();
		
		System.out.println("DatabaseProductName");
		System.out.println(db.getDatabaseProductName());
		
		System.out.println("DatabaseProductVersion");
		System.out.println(db.getDatabaseProductVersion());
		
		System.out.println("DriverName");
		System.out.println(db.getDriverName());
		
		System.out.println("DriverVersion");
		System.out.println(db.getDriverVersion());
		
	}

}