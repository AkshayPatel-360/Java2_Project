package db;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import model.UserPost;

public class PostDBUtil {

	private DataSource datasource;

	public PostDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}
	
	
	public void DeleteUserPost(int postId) throws Exception
	
	{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		
		try
		{
			
			conn = this.datasource.getConnection();
			
			String sql = "DELETE FROM posts WHERE postid = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			pstmt.executeUpdate();
			System.out.print(postId);
			
		}
		
		finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
	
	}
	
	

	public ArrayList<UserPost> getAllPosts() throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<UserPost> allPost = new ArrayList<UserPost>();

		try {

			conn = this.datasource.getConnection();

			String sql = "select * from posts";

			stmt = conn.createStatement();

			res = stmt.executeQuery(sql);

			while (res.next()) {

				int id = res.getInt("postID");
				String emailId = res.getString("email");
				String content = res.getString("content");

				System.out.println(id);

				allPost.add(new UserPost(emailId, content));
			}

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
		return allPost;

	}

	public void insertPost(UserPost userpost) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		String cpost = userpost.getCpost();
		String emailid = userpost.getEmailId();

		System.out.println(cpost);
		System.out.println(emailid);

		try {

			conn = this.datasource.getConnection();

			String sql = String.format("INSERT INTO posts (email,content) VALUES('%s','%s')", emailid, cpost);

			stmt = conn.createStatement();

			stmt.executeUpdate(sql);

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
	}

	public ArrayList<UserPost> getAllPostOfUser(String email) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<UserPost> allPost = new ArrayList<UserPost>();

		try {

			conn = this.datasource.getConnection();
			String sql = "select p.*, count(l.postid) as likes" + " FROM posts p "
					+ " LEFT JOIN social.like l ON  p.postid = l.postid " + "JOIN user u ON  p.emailid = u.email "
					+ "GROUP BY p.postid HAVING p.emailid = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			res = pstmt.executeQuery();

			while (res.next()) {

				int id = res.getInt("postid");
				String emailId = res.getString("emailid");
				String content = res.getString("content");				
				int likes = res.getInt("likes");
				System.out.println(id);

				allPost.add(new UserPost(id, emailId, content, likes));
			}

		} finally {
			// TODO: handle finally clause
			close(conn, stmt, pstmt, res);
		}
		return allPost;

	}

	private void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet res) {

		try {

			if (conn != null) {
				conn.close();
			}

			if (stmt != null) {
				stmt.close();
			}

			if (pstmt != null) {
				pstmt.close();
			}

			if (res != null) {
				res.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public ArrayList<UserPost> getAll(String email) throws Exception {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		ArrayList<UserPost> tempList = new ArrayList<UserPost>();

		try {

			conn = this.datasource.getConnection();

			String sql = String.format("SELECT * FROM posts WHERE email = ? ORDER BY postID DESC");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);

			res = pstmt.executeQuery();

			while (res.next()) {

				String content = res.getString("content");
				int post_id = res.getInt("postID");
				String email_id = res.getString("email");

				tempList.add(new UserPost(content, post_id, email_id));
			}

			return tempList;

		} finally {

			close(conn, stmt, pstmt, res);
		}
	}

}
