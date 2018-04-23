<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form method="POST" action="${pageContext.request.contextPath}/addProduct">
      <table>
              <tr>
                   <td>ID *</td>
                   <td><input type="text" name="ID" /></td>
               </tr>
 
               <tr>
                   <td>Name *</td>
                   <td><input type="text" name="name" /></td>
               </tr>
               
               <tr>
                   <td>Type *</td>
                   <td><input type="text" name="type" /></td>
               </tr>      
               
               <tr>
                   <td>Price *</td>
                   <td><input type="text" name="price" /></td>
               </tr>   
               
               <tr>
                 	<td><input type="submit" value="ADD PRODUCT" /></td>
               
               </tr>
               
   			</table>
   </form>
</body>
</html>