<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--	<script type="text/javascript">
   		function OnSelectedIndex(s1,s2)
   		{
   			var s1 = document.getElementById(s1);
   			var s2 = document.getElementById(s2);
   			
   			s2.innerHTML == "";
   			if(s1.value == "electronics"){
   				
   				var optionArray = ["|","laptop|Laptop","|","desktop|Desktop"];
   			}
   			
   			for(var option in optionArray){
   			
   				var pair = optionArray[option].split("|");
   				var newOption = document.createElement("option");
   				newOption.value = pair[0];
   				newOption.innerHTML = pair[1];
   				s2.options.add(newOption);
   			}
   			
       		
  		 }
   		
   </script>  -->
</head>
<body>
   <form method="POST" action="${pageContext.request.contextPath}/addProduct">
      <table>
               <tr>
                   <td>Name *</td>
                   <td><input type="text" name="name" /></td>
               </tr>
                  
               
               <tr>
                   <td>Price *</td>
                   <td><input type="text" name="price" /></td>
               </tr>   
               
               <tr>
                   <td>Code *</td>
                   <td><input type="text" name="code" /></td>
               </tr>
               
               <tr>
                   <td>Description *</td>
                   <td><input type="text" name="description" /></td>
               </tr>
               
               <tr>
                 <td>Category *</td>
                 <td>
                 	<select id="category" name="category">
                 	  	<option value="books">Books</option>
    					<option value="clothing">Clothing</option>
    					<option value="footwear">Footwear</option>
                 	</select>             
                 </td>
               </tr>
               <tr>
                 	<td><input type="submit" value="ADD PRODUCT" /></td>
               </tr>
               
   			</table>
   	</form>
   
</body>
</html>