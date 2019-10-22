package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdatableResultSet {

	public static void main(String[] args) throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver is loaded");

		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","123456789");
		System.out.println("Connection is created");

		PreparedStatement stmt = con.prepareStatement("select post_id,post_title,post_body from hr.posts", ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.absolute(2);
		System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		rs.first();
		System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
		rs.moveToInsertRow();
		
		rs.updateInt("post_id",24);
        rs.updateString("post_title", "inserting a new title...");
        rs.updateString("post_body", "inserting a new title's body...");
        rs.insertRow();
        rs.moveToCurrentRow();
        rs.last();
        System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3));
	}

}