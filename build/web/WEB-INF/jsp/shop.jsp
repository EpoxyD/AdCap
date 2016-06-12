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
                        <tr>
                            <td><img src="<c:url value="${initParam.inventoryImagePath}lucvandeurzen.png"/>" height="80px"/></td>
                            <td>Linux Luc</td>
                            <td>&#8364 1 / unit</td>
                            <td>For all your Sysprog nightmares</td>
                            <td>50</td>
                            <td>&#8364 1 / second</td>
                            <td><input value="0" id="amount" type="number" class="validate" style="width: 50px;"></td>
                            <td><a class="waves-effect waves-light btn">BUY!</a></td>
                        </tr>
                        <tr>
                            <td><img src="<c:url value="${initParam.inventoryImagePath}lucbienstman.png"/>" height="80px"/></td>
                            <td>Processor Luc</td>
                            <td>&#8364 20 / unit</td>
                            <td>Your PIC18f45 compatible Luc</td>
                            <td>50</td>
                            <td>&#8364 25 / second</td>
                            <td><input value="0" id="amount" type="number" class="validate" style="width: 50px;"></td>
                            <td><a class="waves-effect waves-light btn">BUY!</a></td>
                        </tr>
                        <tr>
                            <td><img src="<c:url value="${initParam.inventoryImagePath}lucgeurts.png"/>" height="80px"/></td>
                            <td>ESAT Luc</td>
                            <td>&#8364 100 / unit</td>
                            <td>From basic electronics to motors</td>
                            <td>50</td>
                            <td>&#8364 120 / second</td>
                            <td><input value="0" id="amount" type="number" class="validate" style="width: 50px;"></td>
                            <td><a class="waves-effect waves-light btn">BUY!</a></td>
                        </tr>
                        <tr>
                            <td><img src="<c:url value="${initParam.inventoryImagePath}lucjanssens.png"/>" height="80px"/></td>
                            <td>Sensor Luc</td>
                            <td>&#8364 150 / unit</td>
                            <td>The EM/EA crossbreed professor</td>
                            <td>50</td>
                            <td>&#8364 200 / second</td>
                            <td><input value="0" id="amount" type="number" class="validate" style="width: 50px;"></td>
                            <td><a class="waves-effect waves-light btn">BUY!</a></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>