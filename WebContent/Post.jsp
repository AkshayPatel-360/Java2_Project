<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


	<form action="CreatePost" method="POST">


		<label>Type Post</label> <input type="text" name="cpost"> <input
			type="submit" value="submit">
	</form>
</body>
</html>