
<%-- 
    Document   : login
    Created on : 10-Jun-2016, 10:40:22
    Author     : Karsten
--%>

<%@include file="include.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
    </head>
    <body>
        <sql:query var="result" dataSource="jdbc/adcap">
            SELECT * FROM user
        </sql:query>
        <h1>HELLO</h1>
        <table border="1">
            <!-- column headers -->
            <tr>
                <c:forEach var="columnName" items="${result.columnNames}">
                    <th><c:out value="${columnName}"/></th>
                    </c:forEach>
            </tr>
            <!-- column data -->
            <c:forEach var="row" items="${result.rowsByIndex}">
                <tr>
                    <c:forEach var="column" items="${row}">
                        <td><c:out value="${column}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>

        <form:form id="loginForm" method="post" action="/AdCap/login" modelAttribute="loginBean">
            <form:label path="username">Enter your user-name</form:label>
            <form:input id="username" name="username" path="username" /><br>
            <form:label path="username">Please enter your password</form:label>
            <form:password id="password" name="password" path="password" /><br>
            <input type="submit" value="Submit" />
        </form:form>            

    </body>
</html>
