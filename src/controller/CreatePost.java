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

//import db.ItemDBUtil;
import db.PostDBUtil;
import model.User;
import model.UserPost;

/**
 * Servlet implementation class CreatePost
 */
@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePost() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Resource(name="jdbc/social")
    private DataSource datasource;
    private PostDBUtil postdb;
    
    
    @Override
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<UserPost> posts = new ArrayList<UserPost>();
        HttpSession session = request.getSession();
        
		User user  =  (User) session.getAttribute("user");
        String cpost = request.getParameter("cpost");
		//String email = request.getParameter("email");
		
		boolean created = user.createPost(cpost,postdb);
		
		if(created) {
			// store user in session if created 
			session.setAttribute("posts", posts);
			
			// redirect to profile page
			
			//session.setAttribute("user", tempUser);
			posts = user.getMyPosts(postdb);
			System.out.println(posts.size() + " size");
			session.setAttribute("postList", posts);
			response.sendRedirect("HomePage.jsp");
		}else {
			//redirect to index page in user in registered with an error
			
			RequestDispatcher dispatch = request.getRequestDispatcher("Post.jsp");
			request.setAttribute("rerror", true);
			dispatch.forward(request, response);
		}
		System.out.println(created);				
	}
		
		
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
