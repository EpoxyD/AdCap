<main>
    <div class="container-fluid" style="height: 100%; width: 100%;">
        <div class="row">
            <div class="col m8">
                <h4>Overview for user ${userDetails.user.getUsername()}</h4>
                <table border="1">
                    <!-- column headers -->
                    <thead>
                        <tr>
                            <th>Lucs in inventory</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    <!-- column data -->
                    <tbody>
                        <c:forEach var="itemInfo" items="${userDetails.itemInfo}" varStatus="loop">
                            <tr>
                                <td><c:out value="${itemInfo.getName()}" /></td> 
                                <td><c:out value="${userDetails.ownedItems.get(loop.index).getQuantity()}" /></td>
                            </tr>
                        </c:forEach>    
                    </tbody>
                </table>
                <h4>The total money rate equals &#8364 ${userDetails.totalRate}/second</h4>
            </div>
        </div>
    </div>
</main>



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
