<main>
    <div class="container-fluid" style="height: 100%; width: 100%;">
        <div class="row">
            <div class="col m9 center">
                <h4>Inventory</h4>
                <c:forEach var="itemInfo" items="${userDetails.itemInfo}" varStatus="loop">
                    <div class="col m4">
                        <a href="luc${itemInfo.getLucId()}">
                            <div class="card teal lighten-3">
                                <div class="card-image">
                                    <img src="<c:url value="${initParam.inventoryImagePath}${itemInfo.getName()}.png" />">
                                    <span class="card-title strokeme">${itemInfo.getName()}</span>
                                </div>
                                <div class="card-content">
                                    <p>${itemInfo.getDescription()}</p>
                                    <p>Amount: ${userDetails.ownedItems.get(loop.index).getQuantity()}</p>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
                <div class="col m12">
                    <a href="shop" class="waves-effect waves-light btn-large full-width">Get some more Luc's at the STORE</a>
                </div>
            </div>
            <div class="col m3 center">
                <h4>Profit: &#8364 ${userDetails.totalRate} / second!</h4>
                <div class="card teal lighten-3 right-margin">
                    <div class="card-content black-text">
                        <h5>Ranking</h5>
                        <table>
                            <thead>
                                <tr>
                                    <th data-field="username">Username</th>
                                    <th data-field="money">Money</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="rank" items="${ranking}">
                                    <tr>
                                        <td>  
                                            <a href=./<c:out value="${rank.getId()}" />>
                                                <div style="height:100%;width:100%">
                                                    <c:out value="${rank.getUsername()}" />
                                                </div>
                                            </a>
                                        </td>
                                        <td>&#8364 ${rank.getMoney()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>


</main>
<script type="text/javascript" src="<c:url value="https://code.jquery.com/jquery-2.1.1.min.js" />"></script>
<script>
    var currentCash = <c:out value="${userDetails.user.getMoney()}" />;
    var currentRate = <c:out value="${userDetails.totalRate}" />;
    $(document).ready(function () {
        setInterval(function () {
            currentCash += currentRate;
            $('#money').text('Money: ' + currentCash);
            var url = window.location.href;
            $.ajax({
                url: url + "/userMoney/" + currentCash + "/id/" +<c:out value="${userDetails.user.getId()}" />,
                type: 'POST'
            });
        }, 1000);
    });

    $(window).bind('beforeunload', function () {

    });
</script>

