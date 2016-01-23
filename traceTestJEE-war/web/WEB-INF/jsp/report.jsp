
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1>Late loans</h1>

<table class="table">
    <thead
        <tr>
            <th>ID</th>
            <th>SUBSCRIBER</th>
            <th>TYPE</th>
            <th>TITLE</th>
            <th>LOAN DATE</th>
            <th>RETURN DATE</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${report}" var="l">               
            <c:forEach items="${l.resources}" var="r">
                
            <tr>
                <td>${l.id}</td>
                <td>${l.suscriber.name}</td>
                <td>${l.suscriber.susType}</td>
                <td>${r.title}</td>
                <td>${l.loanDate}</td>
                <td>${l.returnDate}</td>
            </tr>
            </c:forEach> 
        </c:forEach>  
    </tbody>

</table>



