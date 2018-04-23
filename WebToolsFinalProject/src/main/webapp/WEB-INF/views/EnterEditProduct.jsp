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
   <form method="POST" action="${pageContext.request.contextPath}/enterEditProduct">
   		<table>
   		   <tr>
				<td><b>Product ID</b></td> 
				<td><b>Product name</b></td>
				<td><b>Product price</b></td>
				<td><b>Product type</b></td> 
			</tr>
   			<tr>
				<td><input type="text" name="PID" value="${SessionScope.p.ID}"/></td> 
				<td><input type="text" name="PName" value="${SessionScope.p.pName}"/></td>
				<td><input type="text" name="PPrice" value="${SessionScope.p.pPrice}"/></td>
				<td><input type="text" name="PType" value="${SessionScope.p.pType}"/></td> 
			</tr>
   		</table>
		
		<input type="submit" value="Submit product"/>
   </form>
</body>
</html>