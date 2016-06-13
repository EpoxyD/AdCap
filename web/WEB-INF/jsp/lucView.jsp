<%-- 
    Document   : lucView
    Created on : 12-Jun-2016, 21:46:28
    Author     : Karsten
--%>
<%@include file="include.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Overview for ${luc.getPreferredName()} ${luc.getSurname()}</h1>
        <table border="1" cellpadding="5">
            <caption><h2>Luc's private KULeuven REST information</h2></caption>
            <tr>
                <th>Nr</th>
                <th>Gender</th>
                <th>Surname</th>
                <th>Name</th>
                <th>Mail Adress</th>
                <th>Faculty Affiliation</th>
            </tr>
                <tr>
                    <td><c:out value="${luc.getNr()}" /></td> 
                    <td><c:out value="${luc.getGender()}" /></td>
                    <td><c:out value="${luc.getSurname()}" /></td> 
                    <td><c:out value="${luc.getPreferredName()}" /></td> 
                    <td><c:out value="${luc.getPreferredMailAdress()}" /></td> 
                    <td><c:out value="${luc.getFacultyAffiliation()}" /></td> 
                </tr>            
        </table>
    </body>
</html>
