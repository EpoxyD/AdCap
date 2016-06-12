<%-- 
    Document   : mainPage
    Created on : 10-Jun-2016, 21:35:19
    Author     : Karsten
--%>


<main>
    <div class="container-fluid" style="height: 100%; width: 100%;">
        <div class="row">
            <div class="col m8">
                <h1>Inventory</h1>
                <div class="col m4">
                    <div class="card teal lighten-2">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucvandeurzen.png" />">
                            <span class="card-title">Linux Luc</span>
                        </div>
                        <div class="card-content">
                            <p>Linux Luc Samenvatting</p>
                        </div>
                    </div>
                </div>
                <div class="col m4">
                    <div class="card teal lighten-2">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucgeurts.png" />">
                            <span class="card-title">ESAT Luc</span>
                        </div>
                        <div class="card-content">
                            <p>ESAT Luc Samenvatting</p>
                        </div>
                    </div>
                </div>
                <div class="col m4">
                    <div class="card teal lighten-2">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucjanssens.png" />">
                            <span class="card-title">Sensor Luc</span>
                        </div>
                        <div class="card-content">
                            <p>Sensor Luc Samenvatting</p>
                        </div>
                    </div>
                </div>
                <div class="col m4">
                    <div class="card teal lighten-2">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucbienstman.png" />">
                            <span class="card-title">Processor Luc</span>
                        </div>
                        <div class="card-content">
                            <p>Processor Luc Samenvatting</p>
                        </div>
                    </div>
                </div>
                <div class="col m12">
                    <a href="shop" class="waves-effect waves-light btn-large full-width">Get some more Luc's at the STORE</a>
                </div>
            </div>
            <div class="col m4">
                <div class="card teal z-depth-3">
                    <div class="card-content black-text">
                        <h4>Ranking</h4>
                        <table>
                            <thead>
                                <tr>
                                    <th data-field="username">Name</th>
                                    <th data-field="money">Money</th>
                                    <th data-field="money/second">Money / Second</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Kagie</td>
                                    <td>&#8364 45384</td>
                                    <td>&#8364 1586.21</td>
                                </tr>
                                <tr>
                                    <td>Woetie</td>
                                    <td>&#8364 32156</td>
                                    <td>&#8364 934.65</td>
                                </tr>
                                <tr>
                                    <td>Borgie</td>
                                    <td>&#8364 9642</td>
                                    <td>&#8364 623.65</td>
                                </tr>
                                <tr>
                                    <td>----------</td>
                                    <td>----------</td>
                                    <td>----------</td>
                                </tr>
                                <tr>
                                    <td>----------</td>
                                    <td>----------</td>
                                    <td>----------</td>
                                </tr>
                                <tr>
                                    <td>----------</td>
                                    <td>----------</td>
                                    <td>----------</td>
                                </tr>
                                <tr>
                                    <td>----------</td>
                                    <td>----------</td>
                                    <td>----------</td>
                                </tr>
                                <tr>
                                    <td>----------</td>
                                    <td>----------</td>
                                    <td>----------</td>
                                </tr>
                                <tr>
                                    <td>----------</td>
                                    <td>----------</td>
                                    <td>----------</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

