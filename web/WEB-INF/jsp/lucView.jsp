<%-- 
    Document   : lucView
    Created on : 12-Jun-2016, 21:46:28
    Author     : Karsten
--%>
<%@include file="include.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>${json}</h1>
        <div id="show" align="center"></div>
        <script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>  
            <script>

    $(document).ready(function() {
         
         $('#show').text(json.toString()); 

        });
</script>
    </body>
</html>
