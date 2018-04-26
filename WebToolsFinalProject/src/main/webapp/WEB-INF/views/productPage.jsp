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
	 <form method="POST" action ="addToCart">
     <table cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Product ID</b></td>
			<td><b>Product name</b></td>
			<td><b>Product price</b></td>
			<td><b>Product type</b></td>
		</tr>
		<c:forEach var="prod" items="${productList}">
			<tr >
				<td>"${prod.ID}"</td> 
				<td>"${prod.pName}"></td>
				<td>"${prod.pPrice}"></td>
				<td>"${prod.pType}"></td> 
				 <td>
				<input type="submit" value="Add to cart">                     
                 </td>
		</c:forEach>
	</table>
    </form>

</body>
</html>