<%-- 
    Document   : userView
    Created on : 12-Jun-2016, 16:59:25
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
        <h1>Overview of ${userDetails.user.getUsername()}</h1>
        <table border="1" cellpadding="5">
            <caption><h2>${userDetails.user.getUsername()}'s Luc's</h2></caption>
            <tr>
                <th>Luc</th>
                <th>Amount</th>
            </tr>
            <c:forEach var="itemInfo" items="${userDetails.itemInfo}" varStatus="loop">
                <tr>
                    <td><c:out value="${itemInfo.getName()}" /></td> 
                    <td><c:out value="${userDetails.ownedItems.get(loop.index).getQuantity()}" /></td>
                </tr>
            </c:forEach>               
        </table>
        <h2>${userDetails.user.getUsername()}'s current rate is ${userDetails.totalRate} euro/second!</h2>
    </body>
    
     <form action="<c:url value="/main" />" method="GET">
        <input type="submit" name="action" value="main" />
    </form>
</html>
