<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password], input[type=email] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: solid;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
   justify-content: center;
   align-items: center;
  
} 

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>
<meta charset="ISO-8859-1">
<title>SIGNUP</title>
</head>
<body>

<form action="CreateUser" method="POST">

<h1> CREATE A NEW ACCOUNT</h1>

<input type="text" name="fname" placeholder ="enter your first name" required>

<input type="text" name="lname" placeholder ="enter your last name" required>
 <input type="email" name="email"  placeholder="Enter your email" required><br><br>
 <input type="password" name="pass" placeholder="enter your password" required ><br>
 
 <!-- GENDER  <input id="Male" type="radio" name="gender"  value="Male" checked>USING RADIO BUTTONS
                    <label for="Male">Male</label>
         
                    <input id="Female" type="radio" name="gender" value="Female">
                    <label for="Female">Female</label>
         
                    <input id="Other" type="radio" name="gender" value="other">
                    <label for="Other">Other</label>
                    <br><br>
  -->
   <input type="submit" value="SIGNUP">
 
 </form>
</body>
</html>