<%-- 
    Document   : mainPage
    Created on : 10-Jun-2016, 21:35:19
    Author     : Karsten
--%>
<<<<<<< HEAD


<main>
    <div class="container-fluid" style="height: 100%; width: 100%;">
        <div class="row">
            <div class="col m9 center">
                <h4>Inventory</h4>
                <div class="col m4">
                    <div class="card teal lighten-3">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucvandeurzen.png" />">
                            <span class="card-title strokeme">Linux Luc</span>
                        </div>
                        <div class="card-content">
                            <p>For all your Sysprog nightmares</p>
                        </div>
                    </div>
                </div>
                <div class="col m4">
                    <div class="card teal lighten-3">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucgeurts.png" />">
                            <span class="card-title strokeme">ESAT Luc</span>
                        </div>
                        <div class="card-content">
                            <p>From basic electronics to motors</p>
                        </div>
                    </div>
                </div>
                <div class="col m4">
                    <div class="card teal lighten-3">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucjanssens.png" />">
                            <span class="card-title strokeme">Sensor Luc</span>
                        </div>
                        <div class="card-content">
                            <p>The EM/EA crossbreed professor</p>
                        </div>
                    </div>
                </div>
                <div class="col m4">
                    <div class="card teal lighten-3">
                        <div class="card-image">
                            <img src="<c:url value="${initParam.inventoryImagePath}lucbienstman.png" />">
                            <span class="card-title strokeme">Processor Luc</span>
                        </div>
                        <div class="card-content">
                            <p>Your PIC18f45 compatible Luc</p>
                        </div>
                    </div>
                </div>
                <div class="col m12">
                    <a href="shop" class="waves-effect waves-light btn-large full-width">Get some more Luc's at the STORE</a>
                </div>
            </div>
            <div class="col m3 center">
                <div class="card teal lighten-3 right-margin">
                    <div class="card-content black-text">
                        <h5>Ranking</h5>
                        <table class="table-font">
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
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

=======
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
        <div id="show" align="center">Yo monneh: ${userDetails.user.getMoney()}</div>
        <table border="1" cellpadding="5">
            <caption><h2>User Ranking</h2></caption>
            <tr>
                <th>Username</th>
                <th>Money</th>
            </tr>
            <c:forEach var="user" items="${ranking}">
                <tr>
                    <td>
                        <a href=./user/<c:out value="${user.getId()}" />>
                            <div style="height:100%;width:100%">
                               <c:out value="${user.getUsername()}" />
                            </div>
                        </a>
                    </td>
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
    var currentCash = <c:out value="${userDetails.user.getMoney()}" />;
    var currentRate = <c:out value="${userDetails.totalRate}" />;
    $(document).ready(function() {
                setInterval(function() {
                currentCash += currentRate;
                $('#show').text('Yo Monneh:'+ currentCash); 
                var url = window.location.href;
                $.ajax({
                    url: url+"/userMoney/"+currentCash+"/id/"+<c:out value="${userDetails.user.getId()}" />,
                    type: 'POST'
                });  
                }, 1000);
            });
            
         $(window).bind('beforeunload', function(){          
  
        });
</script>
        
</body>
</html>
>>>>>>> master
