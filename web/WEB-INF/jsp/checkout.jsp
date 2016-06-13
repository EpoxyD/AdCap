<%-- 
    Document   : checkout
    Created on : Jun 12, 2016, 4:22:57 PM
    Author     : wouter
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
        <h1>Hello World!</h1>
        <h2>If everything goes ok, this should be the checkout page</h2>
        <p>And it sure looks like it is ok! gj woetie</p>
        
        <c:if test="${!empty cart && car.numberOfItems != 0}">
            <p> amount of items in cart: ${cart.numberOfItems}</p>
        </c:if>
            
            <table id="cartTable">
                <tr class="header">
                    <th>Luc</th>
                    <th>price</th>
                    <th>quantity</th>
                    <th>total</th>
                </tr>
                
                <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
                    <c:set var="item" value="${cartItem.item}"/>
                    
                    <tr>
                        <td>${item.name}</td>
                        <td>&euro; ${item.price}</td>
                        <td>${cartItem.quantity}</td>
                        <td>&euro; ${cartItem.quantity * item.price}</td>
                    </tr>
                </c:forEach>
            </table>
            
        
        
        
        
        
    <form action="<c:url value="/main/addToCart" />" method="POST">
        <input type="submit" name="action" value="add" />
    </form>
        
    <form action="<c:url value="/main/checkout" />" method="POST">
        <input type="submit" name="action" value="checkout" />
    </form>    
    
    </body>
</html>
