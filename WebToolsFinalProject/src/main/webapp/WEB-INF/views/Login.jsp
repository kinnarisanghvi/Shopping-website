<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	     <form method="POST" action="${pageContext.request.contextPath}/login">
           <table>
               <tr>
                   <td>username *</td>
                   <td><input type="text" name="username" /></td>
               </tr>
 
               <tr>
                   <td>password *</td>
                   <td><input type="text" name="password" /></td>
               </tr>   
               
               <tr>
              	   <td>role *</td>
               	   <td><input type="text" name="role" /></td>
               </tr>
               	   
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Login" /> </td>
               </tr>	   
   			</table>
   			
   	</form>	   
	
</body>
</html>