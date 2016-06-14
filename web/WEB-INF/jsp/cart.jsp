<main>
    <div class="container">
        <div class="row">
            <div class="col m12">
                <table class="highlight centered responsive-table">
                    <thead>
                        <tr class="header">
                            <th>Luc</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th>total</th>
                        </tr>
                    </thead>
                    <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">
                        <c:set var="item" value="${cartItem.item}"/>
                        <tbody>
                            <tr>
                                <td>${item.name}</td>
                                <td>&euro; ${item.price}</td>
                                <td>${cartItem.quantity}</td>
                                <td>&euro; ${cartItem.quantity * item.price}</td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>

                <c:if test="${!empty cart && car.numberOfItems != 0}">
                    <p> amount of items in cart: ${cart.numberOfItems}</p>
                </c:if>    

                <form action="<c:url value="/main/checkout" />" method="POST">
                    <!--        <input type="submit" name="action" value="checkout" />-->
                    <button class="btn waves-effect waves-light full-width" type="submit" name="action" value="checkout">GO!</button>
                </form>
            </div>
        </div>
    </div>
</main>