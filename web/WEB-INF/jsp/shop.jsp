<main>
    <div class="container-fluid">
        <div class="row">
            <div class="col m12">
                <table>
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
                                <td><input value="0" id="amount" type="number" class="validate" style="width: 50px;"></td>
                                <td><a class="waves-effect waves-light btn">Add to Cart</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>