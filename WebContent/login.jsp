<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;
background-image: url(forma.jpg");
}
h1{
text-allign: center;
}

input[type=text], input[type=email], input[type=password] {
  width: 50%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
 
}
 


button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 550%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: 100%;
  padding: 40px 18px;
  background-color: #f44336;
}


.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 50%;
  }
}


 

</style> 
<title>LOGIN PAGE</title>
</head>
<body>
<form action="Login" method="POST">
<h1>LOGIN HERE</h1>
<label>EMAIL ID</label>
 <input type="email" name="email"  placeholder="Enter your email" required><br><br>
 
 <label>PASSWORD</label>
 <input type="password" name="pass" placeholder="enter your password" required ><br>
   
   <input type="checkbox" name="agree">Remember me<br><br>
                  
                   <input type="submit" value="LOGIN">
                   
 </form>
</body>
</html>