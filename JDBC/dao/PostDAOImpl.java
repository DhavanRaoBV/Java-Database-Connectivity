package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDAOImpl implements PostDAO {

	private static Connection con;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","system","123456789");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(Post post) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("insert into hr.posts  values(?,?,?)");
			pst.setInt(1,post.getId());
			pst.setString(2, post.getTitle());
			pst.setString(3, post.getBody());
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int update(Post post) {
		int res = -1;
		try {
			PreparedStatement pst = con.prepareStatement("update hr.posts set post_title = ? , post_body = ? where post_id = ?");
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getBody());
			pst.setInt(3, post.getId());
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
			PreparedStatement pst = con.prepareStatement("delete from hr.posts where post_id = ?");
			pst.setInt(1, id);
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<Post> view() {

		ArrayList<Post> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from hr.posts");
			while (rs.next()) {
				list.add(new Post(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Post view(int id) {
		Post post = new Post();
		try {
			PreparedStatement pst = con.prepareStatement("select * from hr.posts where post_id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				post = new Post(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

}