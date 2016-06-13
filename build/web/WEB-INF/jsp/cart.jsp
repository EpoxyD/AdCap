<main>
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

<!--            <form action="<c:url value='/main/changeQuantity'/>" method="POST">
                <input type="hidden"
                       name="itemId"
                       value="${item.id}">
                <input type="text"
                       maxlength="2"
                       size="2"
                       value="${cartItem.quantity}"
                       name="quantity"
                       style="margin:5px">
                <input type="submit"
                       name="submit"
                       value="update">
            </form>    -->
        </c:forEach>
    </table>

    <form action="<c:url value="/main/checkout" />" method="POST">
        <input type="submit" name="action" value="checkout" />
    </form>
</main>