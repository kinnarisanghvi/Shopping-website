<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <table cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Product ID</b></td>
			<td><b>Product name</b></td>
			<td><b>Product price</b></td>
			<td><b>Product category</b></td>
			<td><b>Product code</b></td>
			<td><b>Product description</b></td>
		</tr>
		<c:forEach var="prod" items="${productList}">
    		<form>
    		  <table>
    		  <tr>	
					<td>${prod.ID}</td> 
					<td>${prod.pName}</td>
					<td>${prod.pPrice}</td>
					<td>${prod.category.categoryName}</td>
					<td>${prod.pCode}</td>
					<td>${prod.description}</td>
				 
				<td><a href="${pageContext.request.contextPath}/addToCart?prodID='${prod.ID}'&prodName='${prod.pName}'">Add to cart</a></td>
    		   </tr>
    		  
    		  </table>
				
    		</form>  
    </c:forEach>           
	</table>
    
</body>
</html>