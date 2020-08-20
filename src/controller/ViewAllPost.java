package controller;


import java.io.IOException;
import java.util.ArrayList;


import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import db.PostDBUtil;
import model.UserPost;



/**
 * Servlet implementation class ViewAllPost
 */
@WebServlet("/ViewAllPost")
public class ViewAllPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/social")
	private DataSource datasource;
    private PostDBUtil postdb;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    
    public ViewAllPost() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
   
    
    
   
   	public void init() throws ServletException {
   		// TODO Auto-generated method stub
   		super.init();
   		
   		try {
   			
   			postdb = new PostDBUtil(datasource);//changed datasource to type cast
   		
   		} catch (Exception e) {
   			// TODO: handle exception
   			throw new ServletException(e);
   		}
   	}
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<UserPost> posts = new ArrayList<UserPost>();
		
		try {
 			posts =  postdb.getAllPosts();
 			 
 			 RequestDispatcher dipatcher = request.getRequestDispatcher("Post.jsp");
 			 
 			 
 			 
 			 request.setAttribute("allpost", posts);
 			 
 			 dipatcher.forward(request, response);
 			 
 			 
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}	
 	}
		
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

