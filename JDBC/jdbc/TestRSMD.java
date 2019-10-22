package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class TestRSMD {

	public static void main(String[] args) throws Exception {
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded");

		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","123456789");
		System.out.println("Connection is created");

		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from hr.posts");
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println("ColumnCount=" + rsmd.getColumnCount());
		System.out.println("ColumnType 1=" + rsmd.getColumnTypeName(1));
	}

}