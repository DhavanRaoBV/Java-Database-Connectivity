package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
		//Loading the  Driver.........................//
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded......");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","123456789");
		System.out.println("Connection is created");
		
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter Post id");
		int post_id=scan.nextInt();
		scan.nextLine();
		
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from hr.posts where post_id="+post_id+" ");
		
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		}

}
