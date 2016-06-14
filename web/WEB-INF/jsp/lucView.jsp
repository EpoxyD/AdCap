
<main>
    <div class="container">
        <div class="row">
            <div class="col m8">
                <caption><h4>${luc.getPreferredName()}'s private KULeuven REST information</h4></caption>
                <table class="centered responsive-table highlight">
                    <thead>
                        <tr>
                            <th>Nr</th>
                            <th>Gender</th>
                            <th>Surname</th>
                            <th>Name</th>
                            <th>Mail Adress</th>
                            <th>Faculty Affiliation</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><c:out value="${luc.getNr()}" /></td> 
                            <td><c:out value="${luc.getGender()}" /></td>
                            <td><c:out value="${luc.getSurname()}" /></td> 
                            <td><c:out value="${luc.getPreferredName()}" /></td> 
                            <td><c:out value="${luc.getPreferredMailAdress()}" /></td> 
                            <td><c:out value="${luc.getFacultyAffiliation()}" /></td> 
                        </tr> 
                    </tbody>
                </table>
            </div>
            <div class="col m4">
                <center>
                    <img src="<c:url value="${initParam.inventoryImagePath}${luc.getPreferredName()} ${luc.getSurname()}.png" />">
                </center>
            </div>
        </div>
    </div>
</main>
