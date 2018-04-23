<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to our store  
</h1>
<body>
    <h3> Enter your credentials</h3>
    
        <form method="POST" action="${pageContext.request.contextPath}/signUp">
           <table>
               <tr>
                   <td>First Name *</td>
                   <td><input type="text" name="firstName" /></td>
               </tr>
 
               <tr>
                   <td>Last Name *</td>
                   <td><input type="text" name="lastName" /></td>
               </tr>
               
               <tr>
                   <td>role *</td>
                   <td><input type="text" name="role" /></td>
               </tr>
 
               <tr>
                   <td>Phone *</td>
                   <td><input type="text" name="phone" /></td>
               </tr>
 
               <tr>
                   <td>Address *</td>
                   <td><input type="text" name="address" /></td>
               </tr>
 
               <tr>
                   <td>Username *</td>
                   <td><input type="text" name="username" /></td>
               </tr>
 
               <tr>
                   <td>Password *</td>
                   <td><input type="text" name="password" /></td>
               </tr>
               
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Login" /> </td>
               </tr>
           </table>
       </form>
  
    
    
	</body>


</html>