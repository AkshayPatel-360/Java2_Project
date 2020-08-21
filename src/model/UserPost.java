package model;

import db.PostDBUtil;
//import db.UserDBUtil;

public class UserPost {
	
	public int postId;
	public String emailId;
	public String contentPost;
	public int likes;
	
	
	public UserPost(int postId,String emailId,String content,String postDate,int likes)
	{
		this.postId = postId;
		this.emailId = emailId;
		this.contentPost = content;
		
		this.likes = likes;
	}
	
	
	public UserPost(int postId,String emailId,String content)
	{
		this.postId = postId;
		this.emailId = emailId;
		this.contentPost = content;
		
	}
	
	public UserPost(String emailId,String content)
	{
		this.emailId = emailId;
		this.contentPost = content;
		
	}
	
	
	public UserPost(String cpost)
	{
		this.contentPost = cpost;
	}
	

	public UserPost(int id, String emailId2, String content, int likes) {
		// TODO Auto-generated constructor stub
	}

	public UserPost(String content, int post_id, String email_id) {
		
		this.contentPost = content;
		this.postId = post_id;
		this.emailId = email_id;
	}


	public void setCpost(String cpost) {
		this.contentPost = cpost;
	}
	
	public int getPostId() {
		return postId;
	}


	public String getCpost() {
		// TODO Auto-generated method stub
		return contentPost;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	public  void DisplayAllPost(PostDBUtil postdb)
	{
		try {
			postdb.getAllPosts();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	


}
