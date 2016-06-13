<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : login
    Created on : 10-Jun-2016, 10:40:22
    Author     : Karsten
--%>

<%@include file="include.jsp"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="<c:url value="/resources/css/mainCSS.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css" />" type="text/css">
        <link rel="stylesheet" href="<c:url value="http://fonts.googleapis.com/icon?family=Material+Icons" />" />
        <link rel="stylesheet" href="<c:url value="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" />">
        <title>Login</title>
    </head>
    <body class="teal lighten-5">
        <sql:query var="result" dataSource="jdbc/adcap">
            SELECT * FROM user
        </sql:query>
    <nav class="teal darken-4">
        <div class="nac-wrapper">
            <a class="brand-logo valign center">A Game Of Lucs</a>
        </div>
    </nav>
    <main class="loginbackground">
        <div class="container">
            <div class="row">
                <div class="col m12">
                    <div class="row">
                        <form:form cssClass="col m12" id="loginForm" method="post" action="/AdCap/login" modelAttribute="loginBean">
                            <div class="loginscreen center">
                                <div class="container">
                                    <div class="row">
                                        <div class="input-field col m12">
                                            <i class="material-icons prefix">account_circle</i>
                                            <form:input id="username" name="username" path="username"/>
                                            <form:label path="username">Enter your username</form:label>
                                            </div>
                                            <div class="input-field col m12">
                                                <i class="material-icons prefix">vpn_key</i>
                                            <form:password id="password" name="password" path="password" />
                                            <form:label path="username">Enter your password</form:label>
                                            </div>
                                            <div class="input-field col m12 center">
                                                <button class="btn waves-effect waves-light full-width" type="submit" name="action">GO!</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                        </form:form>
                    </div>
                </div>


                <!-- <form:form id="loginForm" method="post" action="/AdCap/main/mainpage" modelAttribute="loginBean">
                    <form:label path="username">Enter your username</form:label>
                    <form:input id="username" name="username" path="username" />
                    <form:label path="username">Enter your password</form:label>
                    <form:password id="password" name="password" path="password" />
                    <button class="btn waves-effect waves-light full-width" type="submit" name="action">GO!</button>
                </form:form>-->
            </div>

            <div class="col m12">
                <table border="1">
                    <!-- column headers -->
                    <thead>
                        <tr>
                            <c:forEach var="columnName" items="${result.columnNames}">
                                <th><c:out value="${columnName}"/></th>
                                </c:forEach>
                        </tr>
                    </thead>
                    <!-- column data -->
                    <tbody>
                        <c:forEach var="row" items="${result.rowsByIndex}">
                            <tr>
                                <c:forEach var="column" items="${row}">
                                    <td><c:out value="${column}"/></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
