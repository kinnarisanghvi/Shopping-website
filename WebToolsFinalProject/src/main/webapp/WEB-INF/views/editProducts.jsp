<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
    <form>
     <table cellpadding="5" cellspacing="5">
		<tr>
			<td><b>Product ID</b></td>
			<td><b>Product name</b></td>
			<td><b>Product price</b></td>
			<td><b>Product type</b></td>
		</tr>
		<c:forEach var="prod" items="${productList}">
			<tr >
				<td>${prod.ID}</td> 
				<td>${prod.pName}</td>
				<td>${prod.pPrice}</td>
				<td>${prod.pType}</td> 
				 <td>
                        <a href="${pageContext.request.contextPath}/editProduct?id=${prod.ID}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/deleteProduct?id=${prod.ID}">Delete</a>
                 </td>
		</c:forEach>
	</table>
    
    
    </form>
    </body>
</html>