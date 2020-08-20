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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.PostDBUtil;
import model.UserPost;
import model.User;


@WebServlet("/ViewUserPost")
public class ViewUserPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Resource(name="jdbc/social")
	private DataSource datasource;
    private PostDBUtil postdb;
    
    
    public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			postdb = new PostDBUtil(datasource);
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
       
   
    public ViewUserPost() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<UserPost> posts = new ArrayList<UserPost>();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		try {
			posts = postdb.getAllPostOfUser(user.getEmail());
		
			RequestDispatcher dipatcher = request.getRequestDispatcher("profile.jsp");
			 
			 request.setAttribute("alluserpost", posts);
			 
			 dipatcher.forward(request, response);
		
	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.print(posts);
	System.out.print(user);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
