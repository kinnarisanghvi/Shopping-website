<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<td><b>Product type</b></td>
		</tr>
		<c:forEach var="prod" items="${productList}">
    		<form method="POST" action ="${pageContext.request.contextPath}/actionOnProduct">
   		
			<tr>
				<td><input type="number" name="id" value="${prod.ID}"></td> 
				<td><input type="text" name="pName" value="${prod.pName}"></td>
				<td><input type="number" name="pPrice"  step="0.01" value="${prod.pPrice}"></td>
				<td><input type="text" name="pType" value="${prod.pType}"></td> 
				<td><input type="submit" name="update" value="UpdateButton">
    		        <input type="submit" name="delete" value="DeleteButton">                   
		        </td>
    		</tr>
    		</form>  
    </c:forEach>           
	</table>
    </body>
</html>