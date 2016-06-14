<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col m12">
                <table class="highlight centered responsive-table">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Luc Type</th>
                            <th>Price</th>
                            <th>Description</th>
                            <th>In Stock</th>
                            <th>Profit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="inventory" items="${inventory}">
                            <tr>
                                <td><a href="luc${inventory.getLucId()}"><img src="<c:url value="${initParam.inventoryImagePath}${inventory.getName()}.png"/>" height="80px"/></a></td>
                                <td>${inventory.getName()}</td>
                                <td>&#8364 ${inventory.getPrice()} / unit</td>
                                <td>${inventory.getDescription()}</td>
                                <td>${inventory.getStock()}</td>
                                <td>&#8364 ${inventory.getRate()} / second</td>
                                <td>
                                    <form action="<c:url value="/main/buy"/>" method="POST">
                                        <input type="hidden" name="itemId" value="${inventory.getId()}">
                                        <input value="0" name="quantity" id="amount" type="text" maxlength="2" size="2" x class="validate center" style="width: 50px; margin-right: 10px;">
                                        <button class="btn waves-effect waves-light" type="submit" name="action">Add to Cart</button>
                                    </form>
                                </td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>