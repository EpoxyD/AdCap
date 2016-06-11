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
	<center>Welcome ${userDetails.user.getUsername()}</center>
        <div id="show" align="center"></div>
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
        
        <table border="1" cellpadding="5">
            <caption><h2>Your Luc's</h2></caption>
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
        <h2>Your current rate is ${userDetails.totalRate} euro/second!</h2>
        

        
    <form action="<c:url value="/logout" />" method="POST">
        <input type="submit" name="action" value="logout" />
    </form>
        
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>     
<script>
    $(document).ready(function() {
                $('#show').text('Yo Monneh:'+ 0);
                setInterval(function() {
                    var randomnumber = Math.floor(Math.random() * 100);
                    $('#show').text('Yo Monneh:'+ randomnumber);
                }, 3000);
            });
</script>
        
</body>
</html>
