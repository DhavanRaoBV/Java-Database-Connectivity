package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Todo;

public class TodoDAOImpl implements TodoDAO {

	private static Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","Sys as sysdba","123456789");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Todo todo) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into todo  values(?,?,?,?)");
			pst.setInt(1,todo.getId());
			pst.setString(2, todo.getTask());
			pst.setString(3, todo.getName());
			pst.setString(4, todo.getStatus());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Todo todo) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update todo set task = ? , name = ? ,status = ? where id = ?");
			pst.setString(1, todo.getTask());
			pst.setString(2, todo.getName());
			pst.setString(3, todo.getStatus());
			pst.setInt(4, todo.getId());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int id) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("delete from todo where id = ?");
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Todo> view() {

		ArrayList<Todo> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from todo");
			while (rs.next()) {
				list.add(new Todo(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Todo view(int id) {
		Todo todo = new Todo();
		try {
			PreparedStatement pst = con.prepareStatement("select * from todo where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				todo = new Todo(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return todo;
	}

}