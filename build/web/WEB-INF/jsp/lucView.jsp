
<main>
    <div class="row">
        <div class="col m8">
            <table border="1" cellpadding="5">
                <caption><h4>${luc.getPreferredName()}'s private KULeuven REST information</h4></caption>
                <tr>
                    <th>Nr</th>
                    <th>Gender</th>
                    <th>Surname</th>
                    <th>Name</th>
                    <th>Mail Adress</th>
                    <th>Faculty Affiliation</th>
                </tr>
                <tr>
                    <td><c:out value="${luc.getNr()}" /></td> 
                    <td><c:out value="${luc.getGender()}" /></td>
                    <td><c:out value="${luc.getSurname()}" /></td> 
                    <td><c:out value="${luc.getPreferredName()}" /></td> 
                    <td><c:out value="${luc.getPreferredMailAdress()}" /></td> 
                    <td><c:out value="${luc.getFacultyAffiliation()}" /></td> 
                </tr>            
            </table>
        </div>
    </div>
</main>
