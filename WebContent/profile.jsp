<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>
<%@ page import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<h1>Profile</h1>
	
<% 
	
		ArrayList<UserPost> allPost = (ArrayList<UserPost>) request.getAttribute("allpost");
	
	
		if(allPost == null){
			System.out.print("No Post Avaliable");
			
		}else{
			out.println("<ol>");
			
			
			for(UserPost u : allPost)
			{
				out.println("<li>");
			
					out.print(u.contentPost);
					out.print("<br>");
					out.println(u.emailId);
			 		
				 		
		 		out.println("</li>");
			}
			out.println("</ol>");
		}
		
		
	
	%>
	
	 
</body>
</html>