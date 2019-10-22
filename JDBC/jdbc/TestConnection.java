package jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) throws Exception {
	
		//Loading the  Driver.........................//
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded......");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","123456789");
		System.out.println("Connection is created");
		
		
		
		//<<Query for inserting the data into the table>>//
				
		//String query="insert into hr.posts values(103,'Buisness Analyst','Understanding the buisness requirements and improving the Buisness Startegy')";
		//Statement st=con.createStatement();
		
		
		//<<Run the query>>//
		
		//int res=st.executeUpdate(query);
		//System.out.println("Rows affected"+res);
		
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Enter Post id");
		int post_id=scan.nextInt();
		
		scan.nextLine();
		System.out.println("Enter post title");
		String post_title=scan.nextLine();
		
		System.out.println("Enter post body");
		String post_body=scan.nextLine();
		
		String sql="insert into hr.posts values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,post_id);
		pst.setString(2,post_title);
		pst.setString(3,post_body);
		int i=pst.executeUpdate();
		
		System.out.println("Rows affected:"+i);
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from hr.posts");
		
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
		}
		}
		
		
		
		
		
	

	}


