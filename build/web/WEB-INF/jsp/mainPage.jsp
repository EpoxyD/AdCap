<%-- 
    Document   : mainPage
    Created on : 10-Jun-2016, 21:35:19
    Author     : Karsten
--%>
<%@include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<center>Welcome ${loggedInUser}</center>
     <table border="1" cellpadding="5">
            <caption><h2>User Ranking</h2></caption>
            <tr>
                <th>Username</th>
                <th>Money</th>
            </tr>
            <c:forEach var="user" items="${ranking}">
                <tr>
                    <td><c:out value="${user.getUsername()}" /></td>
                    <td><c:out value="${user.getMoney()}" /></td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
