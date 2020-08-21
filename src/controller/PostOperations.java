package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.PostDBUtil;
import model.User;

@WebServlet("/PostOperations")
public class PostOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Resource(name="jdbc/social")
	 private DataSource datasource;
	 private PostDBUtil postdb;
	 
    public PostOperations() {
        super();
        // TODO Auto-generated constructor stub
    }

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
    
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session = request.getSession();
	User user = (User) session.getAttribute("user");
	String s = request.getParameter("del");
	
	if(s!=null)
	{
		int postId = Integer.parseInt(s);
		try {
			postdb.DeleteUserPost(postId);
			System.out.print(postId);
			response.sendRedirect("ShowOnlyUserPost");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
