<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

    <div>
		<table>
			<tag:forEach var="post" items="${sessionScope.postList}">

				<tr>
					<td><tag:out value="${post.getCpost()}"></tag:out></td>
				</tr>

			</tag:forEach>
		</table>
	</div> 

            <div class="post">
                
              
               <p>${post.getContent()}</p>
              <form action="PostOperations" method="GET">
              
                    
                          
                    
                    <tag:if test="${post.getEmailId() != user.getEmail()}">
                        <button type="submit" value="${post.getPostId()}" name="del" >Delete</button>
                    </tag:if>
                    
                    <input type="hidden" value="Home" name="page">
                </form>
            </div>
      

</body>
</html>